package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class LeetCode_0216 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0216().combinationSum3(9, 45)
        );
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || n > 45) {
            return new ArrayList<>();
        }
        return combinationSum3(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                0,
                k,
                n
        );
    }

    public List<List<Integer>> combinationSum3(int[] nums, int start, int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        if (start >= nums.length || n < 0 || nums[start] > n) {
            return result;
        }

        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> lists = combinationSum3(nums, i + 1, k - 1, n - nums[i]);
            for (List<Integer> list : lists) {
                list.add(0, nums[i]);
                result.add(list);
            }
        }
        return result;
    }

}
