package leetcode.problems;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
// @DP
@Deprecated
public class LeetCode_0010 {

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

        if (p.length() == 1) {
            if (p.charAt(0) == '.') {
                return s != null && s.length() == 1;
            }
            return p.equals(s);
        }

        int[][] tmp = new int[p.length() + 1][s.length() + 1];
        int i = 1;
        char cur = p.charAt(i - 1);
        char next = p.charAt(i);

        if (next == '*') {
            if (cur == '.') {
                tmp[i][0] = 0;
                tmp[i + 1][0] = 1;
                for (int j = 1; j <= s.length(); j++) {
                    tmp[i][j] = 0;
                    tmp[i + 1][j] = 1;
                }
            } else {
                tmp[i][0] = 0;
                tmp[i + 1][0] = 1;
                for (int j = 1; j <= s.length(); j++) {
                    tmp[i][j] = 0;
                    if (tmp[i + 1][j - 1] > 0 && s.charAt(j - 1) == cur) {
                        tmp[i + 1][j] = 1;
                    } else {
                        tmp[i + 1][j] = 0;
                    }
                }
            }
            i += 2;
        } else {
            if (cur == '.') {
                tmp[i][0] = 0;
                if (s.length() > 0) {
                    tmp[i][1] = 1;
                }
                for (int j = 2; j <= s.length(); j++) {
                    tmp[i][j] = 0;
                }
            } else {
                tmp[i][0] = 0;
                if (s.length() > 0) {
                    tmp[i][1] = s.charAt(0) == cur? 1 : 0;
                }
                for (int j = 2; j <= s.length(); j++) {
                    tmp[i][j] = 0;
                }
            }
            i += 1;
        }

        boolean hasNext = false;
        while (i <= p.length()) {
            cur = p.charAt(i - 1);
            hasNext = i < p.length();
            if (hasNext) {
                next = p.charAt(i);
            }

            if (hasNext && next == '*') {
                if (cur == '.') {
                    tmp[i][0] = 0;
                    tmp[i + 1][0] = tmp[i - 1][0];
                    for (int k = 1; k <= s.length(); k++) {
                        tmp[i][k] = 0;
                        if (tmp[i + 1][k - 1] > 0 || tmp[i - 1][k] > 0) {
                            tmp[i + 1][k] = 1;
                        } else {
                            tmp[i + 1][k] = 0;
                        }
                    }
                } else {
                    tmp[i][0] = 0;
                    tmp[i + 1][0] = tmp[i - 1][0];
                    for (int k = 1; k <= s.length(); k++) {
                        tmp[i][k] = 0;
                        if ((tmp[i - 1][k] > 0)
                                || (tmp[i + 1][k - 1] > 0 && s.charAt(k - 1) == cur)) {
                            tmp[i + 1][k] = 1;
                        } else {
                            tmp[i + 1][k] = 0;
                        }
                    }
                }
                i += 2;
            } else {
                if (cur == '.') {
                    tmp[i][0] = 0;
                    for (int k = 1; k <= s.length(); k++) {
                        tmp[i][k] = tmp[i - 1][k - 1];
                    }
                } else {
                    tmp[i][0] = 0;
                    for (int k = 1; k <= s.length(); k++) {
                        if (tmp[i - 1][k - 1] > 0 && s.charAt(k - 1) == cur) {
                            tmp[i][k] = 1;
                        } else {
                            tmp[i][k] = 0;
                        }
                    }
                }
                i += 1;
            }
        }
        return tmp[p.length()][s.length()] > 0;
    }

}
