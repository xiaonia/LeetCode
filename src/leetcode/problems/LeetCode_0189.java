package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class LeetCode_0189 {

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6}, 4);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        int delta = k % nums.length;
        if (delta == 0) {
            return;
        }
        solution2(nums, delta);
        DebugUtils.print(nums);
    }

    private static void solution2(int[] nums, int k) {
        // 球最大公约数
        int size = gcd(nums.length, k);
        int loop = nums.length / size;
        int preValue;
        int nextValue;
        int nextIndex;

        for (int i = 0; i < size; i++) {
            preValue = nums[i];
            for (int j = 1; j <= loop; j++) {
                nextIndex = (i + j * k) % nums.length;
                nextValue = nums[nextIndex];
                nums[nextIndex] = preValue;
                preValue = nextValue;
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else  {
            return gcd(b, a % b);
        }
    }

    private static void solution3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
