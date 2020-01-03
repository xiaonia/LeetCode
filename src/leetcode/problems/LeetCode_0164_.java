package leetcode.problems;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap/
 *
 * 164. Maximum Gap
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * Note:
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 */
@Deprecated
public class LeetCode_0164_ {

    public int maximumGap(int[] nums) {
        return run(nums);
    }

    /**
     * (bits * 10 + 2) * N
     */
    public static int run(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            else if (nums[i] > max) {
                max = nums[i];
            }
        }

        int bits = 0;
        while (max != 0) {
            bits++;
            max = max / 10;
        }

        int[] arr1 = new int[nums.length];
        int[] arr2 = nums;
        int j = 0;
        int val = 0;
        for (int bit = 1; bit <= bits; bit++) {
            nums = arr2;
            arr2 = arr1;
            arr1 = nums;
            j = 0;
            for (int base = 0; base < 10; base++) {
                for (int i = 0; i < arr1.length; i++) {
                    val = (int) (arr1[i] % Math.pow(10, bit) / Math.pow(10, bit - 1));
                    if (val == base) {
                        arr2[j] = arr1[i];
                        j++;
                    }
                }
            }
        }

        nums = arr2;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i] - nums[i - 1], res);
        }

        return res;
    }

    public int maximumGap2(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i:num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }

}
