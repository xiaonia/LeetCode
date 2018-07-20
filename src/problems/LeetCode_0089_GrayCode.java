package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 */
@Deprecated
public class LeetCode_0089_GrayCode {

    public static List<Integer> grayCode(int n) {
        final List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0) {
            return result;
        }

        int count = 0;
        while (count < n) {
            int extra = (int) Math.pow(2, count);
            int length = result.size();
            for (int i = length - 1; i >= 0; i--) {
                result.add(result.get(i) + extra);
            }
            count ++;
        }
        return result;
    }

    public static int bits2int(int[] nums) {
        int result = 0;
        int length = nums.length - 1;
        int index = length;
        while (index >= 0) {
            if (nums[index] != 0) {
                result += nums[index] * Math.pow(2, length - index);
            }
            index --;
        }
        return result;
    }

}
