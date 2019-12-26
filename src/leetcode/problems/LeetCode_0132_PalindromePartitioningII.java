package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
@Deprecated
public class LeetCode_0132_PalindromePartitioningII {

    public int minCut(String s) {
        return run(s) - 1;
    }

    public static int run(String str) {
        Integer[] tempArray = new Integer[str.length()];
        return partition(tempArray, str, 0);
    }

    public static int partition(Integer[] tempArray, String str, int start) {
        if (start >= str.length()) {
            return 0;
        }

        Integer minCount = tempArray[start];
        if (minCount != null) {
            return minCount;
        }

        if (start == str.length() - 1) {
            minCount = 1;
            tempArray[start] = minCount;
            return minCount;
        }

        minCount = partition(tempArray, str, start + 1) + 1;

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
                        minCount = Math.min(minCount,
                                partition(tempArray, str, end + 1) + 1);
                    } else {
                        minCount = Math.min(minCount, 1);
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
                        minCount = Math.min(minCount,
                                partition(tempArray, str, end + 1) + 1);
                    } else {
                        minCount = Math.min(minCount, 1);
                    }
                }
            }
        }

        tempArray[start] = minCount;
        return minCount;
    }

}
