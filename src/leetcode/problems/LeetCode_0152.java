package leetcode.problems;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
@Deprecated
public class LeetCode_0152 {

    public int maxProduct(int[] nums) {
        return run(nums);
    }

    public static int run(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tmp = new int[nums.length];
        tmp[0] = nums[0] == 0? 1 : nums[0];
        int max = nums[0];
        int lastNegative = nums[0] < 0? 0 : -1;
        int firstNegative = lastNegative;
        int lastZero = nums[0] == 0? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp[i] = 1;
                lastZero = i;
                lastNegative = -1;
                firstNegative = -1;
            } else {
                tmp[i] = tmp[i - 1] * nums[i];
                if (nums[i] < 0) {
                    if (lastNegative < 0) {
                        lastNegative = i;
                        if (firstNegative < 0) {
                            firstNegative = i;
                        } else {
                            max = Math.max(max, tmp[i] / tmp[firstNegative]);
                        }
                    } else {
                        max = Math.max(max, tmp[i]);
                        lastNegative = -1;
                    }
                } else {
                    if (lastNegative < 0) {
                        max = Math.max(max, tmp[i]);
                    } else {
                        max = Math.max(max, tmp[i] / tmp[firstNegative]);
                    }
                }
            }
        }
        if (lastZero >= 0) {
            max = Math.max(max, 0);
        }
        return max;
    }

    public static int run2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tmp = new int[nums.length];
        tmp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = 1;
            tmp[i] = tmp[i - 1];
            for (int j = i; j >= 0; j--) {
                if (nums[j] == 0) {
                    tmp[i] = Math.max(tmp[i], 0);
                    break;
                }
                max *= nums[j];
                tmp[i] = Math.max(tmp[i], max);
            }
        }
        return tmp[nums.length - 1];
    }

}
