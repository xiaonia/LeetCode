package leetcode.problems;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * 13. Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
@Deprecated
public class LeetCode_0013 {

    public int romanToInt(String s) {
        return run(s);
    }

    public static int run(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        char cur = 0;
        char next = 0;
        int i = 0;
        while (i < s.length()) {
            cur = s.charAt(i);
            i++;
            if (i < s.length()) {
                next = s.charAt(i);
            } else {
                next = 'N';
            }
            if (cur == 'I') { //1
                if (next == 'V') {
                    result += 4;
                    i++;
                } else if (next == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            }
            else if (cur == 'V') { //5
                result += 5;
            }
            else if (cur == 'X') { //10
                if (next == 'L') {
                    result += 40;
                    i++;
                } else if (next == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            }
            else if (cur == 'L') { //50
                result += 50;
            }
            else if (cur == 'C') { //100
                if (next == 'D') {
                    result += 400;
                    i++;
                } else if (next == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            }
            else if (cur == 'D') { //500
                result += 500;
            }
            else if (cur == 'M') { //1000
                result += 1000;
            }
        }

        return result;
    }
}
