package leetcode.problems;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * 171. Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */
public class LeetCode_0171 {

    public int titleToNumber(String s) {
        return run(s);
    }

    public static int run(String s) {
        if (s == null) {
            return 0;
        }

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n += (s.charAt(i) - 'A' + 1) * ((int) Math.pow(26, s.length() - 1 - i));
        }
        return n;
    }

    public int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }


}
