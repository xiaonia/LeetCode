package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * 217. Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class LeetCode_0217 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0217().containsDuplicate(
                        new int[]{
                                1,2,3,1
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0217().containsDuplicate(
                        new int[]{
                                1,2,3,4
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0217().containsDuplicate(
                        new int[]{
                                1,1,1,3,3,4,3,2,4,2
                        }
                )
        );

    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, null);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, null);
        }
        return false;
    }

    // quick select


}
