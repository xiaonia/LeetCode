package leetcode.problems;

import java.util.List;

/**
 *Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
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
public class LeetCode_0131_PalindromePartitioning {

    public List<List<String>> partition(String s) {
        return null;
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();
        int indexLeft = 0;
        int indexRight = s.length() - 1;
        char charLeft = 0;
        char charRight = 0;

        while (indexLeft <= indexRight) {
            charLeft = s.charAt(indexLeft);
            if (!Character.isLetterOrDigit(charLeft)) {
                indexLeft ++;
                continue;
            }

            charRight = s.charAt(indexRight);
            if (!Character.isLetterOrDigit(charRight)) {
                indexRight --;
                continue;
            }

            if (charLeft != charRight) {
                return false;
            }

            indexLeft ++;
            indexRight --;
        }
        return true;
    }

}
