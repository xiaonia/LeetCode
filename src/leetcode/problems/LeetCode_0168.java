package leetcode.problems;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
@Deprecated
public class LeetCode_0168 {

    public String convertToTitle(int n) {
        return run(n);
    }

    public static String run(int n) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        //int divisor = 0;
        char c = 0;
        while (n > 0) {
            reminder = n % 26;
            if (reminder == 0) {
                reminder = 26;
                n = n / 26 - 1;
            } else {
                n = n / 26;
            }
            c = (char) ('A' - 1 + reminder);
            sb.insert(0, c);
        }
        return sb.toString();
    }

}
