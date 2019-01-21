package leetcode.problems;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
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
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class LeetCode_0127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return run(beginWord, endWord, wordList);
    }

    public int run(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return 0;
        }

        int indexEnd = wordList.indexOf(endWord);
        if (indexEnd < 0) {
            return 0;
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

    private int buildResultList(List<String> wordList, Map<Integer, List<Integer>> maps,
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
            return 0;
        }

        return pathSumEnd + 1;
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
