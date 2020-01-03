package leetcode.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
@Deprecated
public class LeetCode_0020 {

    private static final char BPO = '{';
    private static final char BPS = '}';

    private static final char MPO = '[';
    private static final char MPS = ']';

    private static final char SPO = '(';
    private static final char SPS = ')';

    public boolean isValid(String s) {
        return run(s);
    }

    public static boolean run(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int l = s.length();
        if (l % 2 != 0) {
            return false;
        }

        int[] counts = new int[] {0, 0, 0, 0, 0, 0};
        char c = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < l; i++) {
            c = s.charAt(i);
            if (c == BPO) {
                counts[0] ++;
                if (counts[0] - counts[1] > l - i) {
                    return false;
                }
                stack.push(c);
            }
            else if (c == BPS) {
                counts[1] ++;
                if (stack.isEmpty() || stack.pop() != BPO) {
                    return false;
                }
            }
            else if (c == MPO) {
                counts[2] ++;
                if (counts[2] - counts[3] > l - i) {
                    return false;
                }
                stack.push(c);
            }
            else if (c == MPS) {
                counts[3] ++;
                if (stack.isEmpty() || stack.pop() != MPO) {
                    return false;
                }
            }
            else if (c == SPO) {
                counts[4] ++;
                if (counts[4] - counts[5] > l - i) {
                    return false;
                }
                stack.push(c);
            }
            else if (c == SPS) {
                counts[5] ++;
                if (stack.isEmpty() || stack.pop() != SPO) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
