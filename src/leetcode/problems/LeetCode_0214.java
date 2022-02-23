package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * 214. Shortest Palindrome
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class LeetCode_0214 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0214().shortestPalindrome(
                        "aacecaaa"
                )
        );
        DebugUtils.print(
                new LeetCode_0214().shortestPalindrome(
                        "abcd"
                )
        );
    }

    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                index = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = s.length() - 1; j > index; j--) {
            sb.append(s.charAt(j));
        }
        sb.append(s);
        return sb.toString();
    }

    private boolean isPalindrome(String s, int start, int end) {
        int lo = start;
        int hi = end;
        while (lo < hi && s.charAt(lo) == s.charAt(hi)) {
            lo++;
            hi--;
        }
        return lo >= hi;
    }

    //TODO KMP
    // s + "#" + s.reverse()

}
