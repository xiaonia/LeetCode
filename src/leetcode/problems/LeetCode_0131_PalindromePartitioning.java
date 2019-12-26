package leetcode.problems;

import java.util.*;

/**
 *Given a string s, partition s such that [ every ] substring of the partition is a palindrome.
 *
 * Return [ all ] possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
@Deprecated
public class LeetCode_0131_PalindromePartitioning {

    public List<List<String>> partition(String str) {
        return run(str);
    }

    public static List<List<String>> run(String str) {
        Map<Integer, List<List<String>>> tmpMap = new HashMap<>();
        return partition(tmpMap, str, 0);
    }

    public static List<List<String>> partition(Map<Integer, List<List<String>>> tmpMap, String str, int start) {
        List<List<String>> lists = tmpMap.get(start);
        if (lists != null) {
            return lists;
        }

        lists = new ArrayList<>();
        tmpMap.put(start, lists);
        if (start >= str.length()) {
            return lists;
        }

        if (start == str.length() - 1) {
            List<String> list = new ArrayList<>();
            list.add(str.substring(start, start + 1));
            lists.add(list);
            return lists;
        }

        List<List<String>> nextLists = partition(tmpMap, str, start + 1);
        for (List<String> nextList : nextLists) {
            List<String> list = new ArrayList<>();
            list.add(str.substring(start, start + 1));
            list.addAll(nextList);
            lists.add(list);
        }

        int count = 0;
        int end = 0;
        int offset = 0;

        for (int i = start + 1; i < str.length(); i++) {
            count = i - start;
            end = i - 1 + count;
            offset = -1;
            if (end >= str.length()) {
                break;
            }

            for (int j = 0; j < count; j++) {
                if (str.charAt(i - j - 1) != str.charAt(i + j + 1 + offset)) {
                    break;
                }

                if (j == count - 1) {
                    if (end + 1 < str.length()) {
                        nextLists = partition(tmpMap, str, end + 1);
                        for (List<String> nextList : nextLists) {
                            List<String> list = new ArrayList<>();
                            list.add(str.substring(start, end + 1));
                            list.addAll(nextList);
                            lists.add(list);
                        }
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(str.substring(start, end + 1));
                        lists.add(list);
                    }
                }
            }

            count = i - start;
            end = i + count;
            offset = 0;
            if (end >= str.length()) {
                break;
            }

            for (int j = 0; j < count; j++) {
                if (str.charAt(i - j - 1) != str.charAt(i + j + 1 + offset)) {
                    break;
                }

                if (j == count - 1) {
                    if (end + 1 < str.length()) {
                        nextLists = partition(tmpMap, str, end + 1);
                        for (List<String> nextList : nextLists) {
                            List<String> list = new ArrayList<>();
                            list.add(str.substring(start, end + 1));
                            list.addAll(nextList);
                            lists.add(list);
                        }
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(str.substring(start, end + 1));
                        lists.add(list);
                    }
                }
            }
        }

        return lists;
    }
}
