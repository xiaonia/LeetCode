package leetcode.problems;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
@Deprecated
public class LeetCode_0151 {

    public String reverseWords(String s) {
        return run(s);
    }

    public static String run(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        char c;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (c == ' ') {
                if (end >= 0) {
                    if (flag) {
                        appendSubstring(s, i, end + 1, sb);
                    }  else {
                        appendSubstring(s, i + 1, end + 1, sb);
                        flag = true;
                    }
                    end = -1;
                }
            } else {
                if (end < 0) {
                    end = i;
                }
                if (i == 0) {
                    if (flag) {
                        sb.append(' ');
                    }
                    appendSubstring(s, i, end + 1, sb);
                }
            }
        }
        return sb.toString();
    }

    private static void appendSubstring(String s, int start, int end, StringBuilder sb) {
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
    }

}
