package leetcode.problems;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
// @DP
@Deprecated
public class LeetCode_0044 {

    public boolean isMatch(String s, String p) {
        return run(s, p);
    }

    public static boolean run(String s, String p) {
        if (p == null) {
            return s == null;
        }
        if ("".equals(p)) {
            return "".equals(s);
        }
        Integer[][] tmp = new Integer[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, tmp);
    }

    private static boolean isMatch(
            String s, String p, int is, int ip, Integer[][] tmp) {

        if (ip >= p.length()) {
            return false;
        }

        Integer value = null;
        if (is <= s.length()) {
            value = tmp[is][ip];
        }

        if (value != null) {
            return value > 0;
        }

        boolean isMatch = false;
        char c = p.charAt(ip);

        if (c == '?') {
            if (ip == p.length() - 1) {
                isMatch = (is == s.length() - 1);
            } else {
                if (is < s.length()) {
                    isMatch = isMatch(s, p, is + 1, ip + 1, tmp);
                } else {
                    isMatch = false;
                }
            }
        } else if (c == '*') {
            if (ip == p.length() - 1) {
                isMatch = true;
            } else {
                for (int i = is; i <= s.length(); i++) {
                    if (isMatch(s, p, i, ip + 1, tmp)) {
                        isMatch = true;
                        break;
                    }
                }
            }
        } else {
            if (ip == p.length() - 1) {
                return is == s.length() - 1
                        && s.charAt(is) == c;
            } else {
                if (is < s.length()) {
                    isMatch = s.charAt(is) == c
                            && isMatch(s, p, is + 1, ip + 1, tmp);
                } else {
                    isMatch = false;
                }
            }
        }

        tmp[is][ip] = isMatch? 1 : 0;
        return isMatch;
    }

    public static boolean isMatch2(String s, String p) {
        if (p == null) {
            return s == null;
        }

        if ("".equals(p)) {
            return "".equals(s);
        }

        int[][] tmp = new int[p.length() + 1][s.length() + 1];
        char c = p.charAt(0);
        if (c == '?') {
            tmp[1][0] = 0;
            if (s.length() > 0) {
                tmp[1][1] = 1;
            }
            for (int j = 2; j <= s.length(); j++) {
                tmp[1][j] = 0;
            }
        } else if (c == '*') {
            for (int j = 0; j <= s.length(); j++) {
                tmp[1][j] = 1;
            }
        } else {
            tmp[1][0] = 0;
            if (s.length() > 0) {
                tmp[1][1] = s.charAt(0) == c? 1 : 0;
            }
            for (int j = 2; j <= s.length(); j++) {
                tmp[1][j] = 0;
            }
        }

        for (int i = 2; i <= p.length(); i++) {
            c = p.charAt(i - 1);
            if (c == '?') {
                tmp[i][0] = 0;
                for (int k = 1; k <= s.length(); k++) {
                    tmp[i][k] = tmp[i - 1][k - 1];
                }
            } else if (c == '*') {
                tmp[i][0] = tmp[i - 1][0];
                for (int k = 1; k <= s.length(); k++) {
                    tmp[i][k] = 0;
                    if (tmp[i][k - 1] > 0 || tmp[i - 1][k] > 0) {
                        tmp[i][k] = 1;
                    } else {
                        tmp[i][k] = 0;
                    }
                }
            } else {
                tmp[i][0] = 0;
                for (int k = 1; k <= s.length(); k++) {
                    if (tmp[i - 1][k - 1] > 0 && s.charAt(k - 1) == c) {
                        tmp[i][k] = 1;
                    } else {
                        tmp[i][k] = 0;
                    }
                }
            }
        }
        return tmp[p.length()][s.length()] > 0;
    }

}
