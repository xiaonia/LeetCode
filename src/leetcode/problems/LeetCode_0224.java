package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * 224. Basic Calculator
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class LeetCode_0224 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        "2147483647"
                )
        );
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        "(1)"
                )
        );
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        "1 + 1"
                )
        );
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        " 2-1 + 2 "
                )
        );
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        "( 2-1 + 2 )"
                )
        );
        DebugUtils.print(
                new LeetCode_0224().calculate(
                        "(1+(4+5+2)-3)+(6+8)"
                )
        );
    }

    public int calculate(String s) {
        char plus = '+';
        char minus = '-';
        char space = ' ';
        char openParenthesis = '(';
        char closeParenthesis = ')';
        int none = -1;
        int flag_plus = 1;
        int flag_minus = -1;
        int num_start = '0';
        int num_end = '9';

        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char c;
        int sum = 0;
        int flag = 1;
        int start = none;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            if (c == space) {
                continue;
            }
            if (c == openParenthesis) {
                stack.push(sum);
                stack.push(flag);
                sum = 0;
                flag = flag_plus;
                continue;
            }

            if (c >= num_start && c <= num_end) {
                if (start <= none) {
                    start = i;
                }
                continue;
            }

            if (start > none) {
                num = charToNum(chars, start, i - 1);
                sum += flag * num;
                start = none;
            }
            if (c == closeParenthesis) {
                sum = stack.pop() * sum + stack.pop();
                continue;
            }
            if (c == plus) {
                flag = flag_plus;
                continue;
            }
            if (c == minus) {
                flag = flag_minus;
                continue;
            }
        }

        if (start > none) {
            num = charToNum(chars, start, chars.length - 1);
            sum += flag * num;
        }

        return sum;
    }

    public int charToNum(char[] chars, int start, int end) {
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            num = num * 10 + (chars[i] - '0');
        }
        return num;
    }

}
