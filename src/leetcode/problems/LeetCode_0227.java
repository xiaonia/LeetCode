package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * 227. Basic Calculator II
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class LeetCode_0227 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0227().calculate(
                        "3+3*2*2/3"
                )
        );
        DebugUtils.print(
                new LeetCode_0227().calculate(
                        " 3/2 "
                )
        );
        DebugUtils.print(
                new LeetCode_0227().calculate(
                        " 3+5 / 2 "
                )
        );
    }

    public int calculate(String s) {
        char char_blank = ' ';
        char char_plus = '+';
        char char_minus = '-';
        char char_multiply = '*';
        char char_divide = '/';

        char[] chars = s.toCharArray();
        char char_mark = char_plus;
        int sum = 0;
        int num = 0;
        int tmp = 0;
        int i = -1;
        char c;
        while (i <= chars.length) {
            i++;
            if (i < chars.length) {
                c = chars[i];
                if (c == char_blank) {
                    continue;
                }
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    continue;
                }
            } else {
                c = char_plus;
            }

            if (c == char_plus || c == char_minus) {
                if (char_mark == char_multiply) {
                    sum += tmp * num;
                }
                else if (char_mark == char_divide) {
                    sum += tmp / num;
                } else if (char_mark == char_plus) {
                    sum += num;
                } else if (char_mark == char_minus) {
                    sum -= num;
                }
            } else {
                if (char_mark == char_multiply) {
                    tmp = tmp * num;
                } else if (char_mark == char_divide) {
                    tmp = tmp / num;
                } else if (char_mark == char_plus) {
                    tmp = num;
                } else if (char_mark == char_minus) {
                    tmp = -num;
                }
            }

            num = 0;
            char_mark = c;
        }

        return sum;
    }

}
