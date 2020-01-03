package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-number/
 *
 * 179. Largest Number
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
@Deprecated
public class LeetCode_0179 {

    public String largestNumber(int[] nums) {
        return run(nums);
    }

    public static String run(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        int[][] tmps = new int[nums.length][];
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int size = 0;
        int k = 0;
        int tmp[];
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (num == 0) {
                stack.push(0);
            } else {
                while (num != 0) {
                    stack.push(num % 10);
                    num = num / 10;
                }
            }

            size = stack.size();
            tmps[i] = new int[size];
            k = 0;
            while (k < size) {
                tmps[i][k] = stack.pop();
                k++;
            }

            for (int j = 0; j < i; j++) {
                if (compareNum(tmps, j, i)) {
                    num = nums[i];
                    tmp = tmps[i];
                    for (int m = i; m > j; m--) {
                        nums[m] = nums[m - 1];
                        tmps[m] = tmps[m - 1];
                    }
                    nums[j] = num;
                    tmps[j] = tmp;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    private static boolean compareNum(int[][] tmps, int i, int j) {
        int[] bits1 = tmps[i];
        int[] bits2 = tmps[j];
        int bit1;
        int bit2;
        int k = 0;
        int length = bits1.length + bits2.length;
        while (k < length) {
            if (k < bits1.length) {
                bit1 = bits1[k];
            } else {
                bit1 = bits2[k - bits1.length];
            }

            if (k < bits2.length) {
                bit2 = bits2[k];
            } else {
                bit2 = bits1[k - bits2.length];
            }

            if (bit1 > bit2) {
                return false;
            } else if (bit1 < bit2) {
                return true;
            }
            k++;
        }

        return false;
    }

}
