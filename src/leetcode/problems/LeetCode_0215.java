package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class LeetCode_0215 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0215().findKthLargest(
                        new int[]{
                                3,2,3,1,2,4,5,5,6
                        },
                        4
                )
        );
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int key = nums[start];
        int lo = start;
        int hi = end;
        while (lo <= hi) {
            if (nums[lo] >= key) {
                lo++;
                continue;
            }
            swap(nums, lo, hi);
            hi--;
        }
        swap(nums, start, hi);
        quickSort(nums, start, hi - 1);
        quickSort(nums, hi + 1, end);
    }

    private void swap(int[] nums, int from, int to) {
        if (from == to) {
            return;
        }
        nums[from] ^= nums[to];
        nums[to] ^= nums[from];
        nums[from] ^= nums[to];
    }

    // TODO
    int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

}
