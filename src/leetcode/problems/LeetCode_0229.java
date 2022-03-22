package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 *
 * 229. Majority Element II
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class LeetCode_0229 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0229().majorityElement(
                        new int[]{
                                2,1,1,3,1,4,5,6
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0229().majorityElement(
                        new int[]{
                                1, 1, 1, 3, 3, 2, 2, 2
                        }
                )
        );
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int firstNum = 0;
        int firstCount = 0;
        int secondNum = 0;
        int sectionCount = 0;
        for (int num : nums) {
            if (firstCount > 0 && firstNum == num) {
                firstCount++;
                continue;
            }
            if (sectionCount > 0 && secondNum == num) {
                sectionCount++;
                continue;
            }

            if (firstCount == 0) {
                firstNum = num;
                firstCount = 1;
                continue;
            }
            if (sectionCount == 0) {
                secondNum = num;
                sectionCount = 1;
                continue;
            }

            firstCount--;
            sectionCount--;
        }

        boolean hasFirstNum = firstCount > 0;
        boolean hasSecondNum = sectionCount > 0;

        firstCount = 0;
        sectionCount = 0;
        for (int num : nums) {
            if (firstNum == num) {
                firstCount++;
            }
            else if (secondNum == num) {
                sectionCount++;
            }
        }

        if (hasFirstNum && firstCount > nums.length / 3) {
            list.add(firstNum);
        }
        if (hasSecondNum && sectionCount > nums.length / 3) {
            list.add(secondNum);
        }

        return list;
    }

    //快速排序
    public static int quickSort(int[] nums, int startIndex, int endIndex) {
        int midIndex = startIndex;
        int midNum = nums[midIndex];
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] <= midNum) {
                swap(nums, midIndex++, i);
            }
        }
        swap(nums, startIndex, midIndex);
        return midIndex;
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
