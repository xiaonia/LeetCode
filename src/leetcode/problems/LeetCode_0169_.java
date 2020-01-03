package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class LeetCode_0169_ {

    public int majorityElement(int[] nums) {
        return run(nums);
    }

    public static int run(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums[0];
        }

        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Integer count;
        int max = length / 2;
        for (int i = 0; i < nums.length; i++) {
            count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                count = count + 1;
                if (count > max) {
                    return nums[i];
                }
                map.put(nums[i], count);
            }
        }
        return 0;
    }

    public int majorityElement2(int[] num) {
        int major = num[0], count = 1;
        for(int i = 1; i < num.length; i++){
            if (count == 0){
                count ++;
                major = num[i];
            } else if (major == num[i]){
                count ++;
            } else {
                count --;
            }
        }
        return major;
    }

}
