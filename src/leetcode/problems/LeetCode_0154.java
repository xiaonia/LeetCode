package leetcode.problems;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 154. Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
@Deprecated
public class LeetCode_0154 {

    public int findMin(int[] nums) {
        return run(nums);
    }

    public static int run(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = (left + right) / 2;
        while (left < mid) {
            if (nums[left] < nums[mid]) {
                left = mid;
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else {
                if (nums[left] > nums[right]) {
                    left = mid;
                } else {
                    for (int i = left + 1; i <= mid; i++) {
                        if (nums[i] == nums[left]) {
                            continue;
                        }
                        if (nums[i] < nums[left]) {
                            return nums[i];
                        }
                        if (nums[i] > nums[left]) {
                            mid = i;
                            break;
                        }
                    }
                    left = mid;
                }
            }
            mid = (left + right) / 2;
        }

        return Math.min(nums[left], nums[right]);
    }

}
