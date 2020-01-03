package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * 166. Fraction to Recurring Decimal
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
@Deprecated
public class LeetCode_0166 {

    public String fractionToDecimal(int numerator, int denominator) {
        return run(numerator, denominator);
    }

    public static String run(long numerator, long denominator) {
        boolean isPositive = true;
        if (numerator < 0) {
            isPositive = false;
            numerator = -numerator;
        }
        if (denominator < 0) {
            isPositive = !isPositive;
            denominator = -denominator;
        }
        long quotient = numerator / denominator;
        long reminder = numerator % denominator;
        if (reminder == 0 && quotient == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        if (!isPositive) {
            result.append('-');
        }
        result.append(quotient);
        if (reminder == 0) {
            return result.toString();
        }
        result.append('.');

        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put(reminder, 0);
        int index = 0;
        while (true) {
            numerator = reminder * 10;
            quotient = numerator / denominator;
            reminder = numerator % denominator;
            sb.append(quotient);

            if (map.containsKey(reminder)) {
                index = map.get(reminder);
                result.append(sb.subSequence(0, index));
                result.append('(');
                result.append(sb.subSequence(index, sb.length()));
                result.append(')');
                return result.toString();
            } else {
                if (reminder == 0) {
                    return result.append(sb).toString();
                }
                index++;
                map.put(reminder, index);
            }
        }
    }

}
