package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * 213. House Robber II
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class LeetCode_0213 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0213().rob(
                        new int[]{1, 2, 3, 1}
                )
        );
        DebugUtils.print(
                new LeetCode_0213().rob(
                        new int[]{2, 3, 2}
                )
        );
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] table = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                table[i][j] = -1;
            }
        }
        table[0][0] = nums[0];
        table[1][1] = nums[1];
        table[0][1] = Math.max(nums[0], nums[1]);
        return Math.max(
                dp(nums, table, 0, nums.length - 2),
                dp(nums, table, 1, nums.length - 1)
        );
    }

    // dp
    private static int dp(int[] nums, int[][] table, int start, int end) {
        if (end < start) {
            return 0;
        }

        if (table[start][end] >= 0) {
            return table[start][end];
        }

        if (end == start) {
            table[start][end] = nums[start];
        } else if (end - start == 1) {
            table[start][end] = Math.max(nums[start], nums[end]);
        } else if (end - start == 2) {
            table[start][end] = Math.max(nums[start] + nums[end], nums[start + 1]);
        } else {
            table[start][end] = Math.max(
                    Math.max(
                            dp(nums, table, start, end - 1),
                            dp(nums, table, start, end - 2) + nums[end]
                    ),
                    Math.max(
                            dp(nums, table, start + 1, end),
                            dp(nums, table, start + 2, end) + nums[start]
                    )
            );
        }
        return table[start][end];
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
                rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1)
        );
    }

    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }

}
