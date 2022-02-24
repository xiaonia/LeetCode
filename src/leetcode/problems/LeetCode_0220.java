package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 * 220. Contains Duplicate III
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class LeetCode_0220 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0220().containsNearbyAlmostDuplicate(
                        new int[]{
                                1, 2, 3, 1
                        },
                        3,
                        0
                )
        );
        DebugUtils.print(
                new LeetCode_0220().containsNearbyAlmostDuplicate(
                        new int[]{
                                -2147483648, 2147483647
                        },
                        1,
                        1
                )
        );
        DebugUtils.print(
                new LeetCode_0220().containsNearbyAlmostDuplicate(
                        new int[]{
                                1,5,9,1,5,9
                        },
                        2,
                        3
                )
        );
    }

    // 溢出
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) < 0) {
                    if (Math.abs(nums[i]) <= t
                            && Math.abs(nums[j]) <= t
                            && Math.abs(nums[i]) <= (Math.abs(nums[j]) - t)) {
                        return true;
                    }
                } else {
                    if (Math.abs(nums[i] - nums[j]) <= t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    private static boolean isAtMost(int[] nums, int start, int end, int k, int t) {
        if (end - start > k) {
            return false;
        }
        if ((nums[start] ^ nums[end]) < 0) {
            if (Math.abs(nums[start]) <= t
                    && Math.abs(nums[end]) <= t
                    && Math.abs(nums[start]) <= (Math.abs(nums[end]) - t)
            ) {
                return true;
            }
        } else {
            if (Math.abs(nums[start] - nums[end]) <= t) {
                return true;
            }
        }
        return true;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int key = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < key) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, start, index);

        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    public static void swap(int[] nums, int from, int to) {
        if (from == to) {
            return;
        }
        nums[from] ^= nums[to];
        nums[to] ^= nums[from];
        nums[from] ^= nums[to];
    }

}
