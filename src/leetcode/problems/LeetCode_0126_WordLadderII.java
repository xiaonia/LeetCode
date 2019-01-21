package leetcode.problems;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

//图最短路径算法？

/**
 * 归纳法可证明：
 * 终点与起点之间最短路径上的每个点，与起点之间都是最短路径
 */
public class LeetCode_0126_WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return run(beginWord, endWord, wordList);
    }

    public List<List<String>> run(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return new ArrayList<>();
        }

        int indexEnd = wordList.indexOf(endWord);
        if (indexEnd < 0) {
            return new ArrayList<>();
        }

        int indexStart = wordList.indexOf(beginWord);
        if (indexStart < 0) {
            wordList.add(0, beginWord);
            indexStart = 0;
            indexEnd += 1;
        }

        final Map<Integer, List<Integer>> maps = new HashMap<>();
        final int diffLimit = 1;
        for (int i = 0; i < wordList.size(); i++) {
            buildCacheMap(wordList.get(i), i, i + 1, wordList, maps, diffLimit);
        }

        return buildResultList(wordList, maps, indexStart, indexEnd);
    }

    private List<List<String>> buildResultList(List<String> wordList, Map<Integer, List<Integer>> maps,
                                               int indexStart, int indexEnd) {

        Map<Integer, Integer> pathMap = new HashMap<>();
        List<Integer> indexList = null;
        Queue<Integer> indexQueue = new ArrayDeque<>();
        int count = 0;
        int size = 1;
        int pathSum = 0;
        Integer index = indexStart;
        boolean stop = false;

        while (true) {
            if (index == null) {
                break;
            }

            if (index == indexEnd) {
                stop = true;
            }
            if (!pathMap.containsKey(index)) {
                pathMap.put(index, pathSum);
            }
            indexList = maps.get(index);
            if (indexList != null) {
                for (int item : indexList) {
                    if (!pathMap.containsKey(item)) {
                        indexQueue.add(item);
                    }
                }
            }
            count += 1;

            if (count >= size) {
                if (stop) {
                    break;
                }
                size = indexQueue.size();
                count = 0;
                pathSum += 1;
            }
            index = indexQueue.poll();
        }

        Integer pathSumEnd = pathMap.get(indexEnd);
        if (pathSumEnd == null) {
            return new ArrayList<>();
        }

        return buildPathList(wordList, maps, pathMap, indexEnd, pathSumEnd);
    }

    private List<List<String>> buildPathList(List<String> wordList, Map<Integer, List<Integer>> maps,
                                             Map<Integer, Integer> pathMap, int index, int pathSum) {

        List<List<String>> resultList = new ArrayList<>();
        List<String> strList = null;
        String word = wordList.get(index);
        if (pathSum == 0) {
            strList = new ArrayList<>();
            strList.add(word);
            resultList.add(strList);
            return resultList;
        }

        List<List<String>> lists = null;
        Integer pathSumPre = null;
        List<Integer> indexList = maps.get(index);
        for (int indexPre : indexList) {
            pathSumPre = pathMap.get(indexPre);
            if (pathSumPre == null || pathSumPre != pathSum - 1) {
                continue;
            }

            lists = buildPathList(wordList, maps, pathMap, indexPre, pathSumPre);
            for (List<String> list : lists) {
                strList = new ArrayList<>(list);
                strList.add(word);
                resultList.add(strList);
            }
        }

        return resultList;
    }

    private void buildCacheMap(String word, int index, int start,
                              List<String> wordList, Map<Integer, List<Integer>> maps, int limit) {
        List<Integer> list = null;
        for (int j = start; j < wordList.size(); j++) {
            int diff = calDiffWithinLimit(word, wordList.get(j), limit);
            if (diff == limit) {
                list = maps.get(index);
                if (list == null) {
                    list = new ArrayList<>();
                    maps.put(index, list);
                }
                list.add(j);

                list = maps.get(j);
                if (list == null) {
                    list = new ArrayList<>();
                    maps.put(j, list);
                }
                list.add(index);
            }
        }
    }

    private int calDiffWithinLimit(String word1, String word2, int limit) {
        //if (word1 == null || word2 == null) {}
        //if (word1.length() != word2.length()) {}
        int length = word1.length();
        int diff = 0;
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                continue;
            }
            diff ++;
            if (diff > limit) {
                return diff;
            }
        }
        return diff;
    }

}
