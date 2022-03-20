package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 *
 * 228. Summary Ranges
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class LeetCode_0228 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0228().summaryRanges(
                        new int[]{
                                0,1,2,4,5,7
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0228().summaryRanges(
                        new int[]{
                                0,2,3,4,6,8,9
                        }
                )
        );
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i < nums.length && nums[i] - nums[i - 1] == 1) {
                continue;
            }
            if (nums[i - 1] == start) {
                list.add("" + nums[i - 1]);
            } else {
                list.add(start + "->" + nums[i - 1]);
            }
            if (i < nums.length) {
                start = nums[i];
            }
        }
        return list;
    }

}
