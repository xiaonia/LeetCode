package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
@Deprecated
public class LeetCode_0128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        return run(nums);
    }

    public int run(int[] nums) {
        int result = 0;
        int num = 0;

        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            map.put(num, i);
        }

        final int[] arrayPre = new int[nums.length];
        final int[] arrayNext = new int[nums.length];
        Integer index = null;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            index = map.get(num - 1);
            arrayPre[i] = index == null? -1 : index;
            index = map.get(num + 1);
            arrayNext[i] = index == null? -1 : index;
        }

        int count = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arrayPre[i] >= 0) {
                continue;
            }

            next = arrayNext[i];
            count = 1;
            while (next >= 0) {
                count ++;
                next = arrayNext[next];
            }

            if (count > result) {
                result = count;
            }
        }

        return result;
    }

    //https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
    public int runII(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Integer value = null;
        int num = 0;
        int sumPre = 0;
        int sumNext = 0;
        int sumCur = 0;

        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (!map.containsKey(num)) {
                sumCur = 1;

                value = map.get(num - 1);
                sumPre = value == null? 0 : value;
                sumCur += sumPre;

                value = map.get(num + 1);
                sumNext = value == null? 0 : value;
                sumCur += sumNext;

                if (sumCur > result) {
                    result = sumCur;
                }

                map.put(num, sumCur); //防重
                map.put(num - sumPre, sumCur); //更新左右边界信息
                map.put(num + sumNext, sumCur);
            }
        }

        return result;
    }

}
