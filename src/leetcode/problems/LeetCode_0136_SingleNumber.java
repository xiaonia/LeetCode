package leetcode.problems;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class LeetCode_0136_SingleNumber {

    public int singleNumber(int[] nums) {
        return run(nums);
    }

    //https://leetcode.com/problems/single-number/discuss/42997/My-O(n)-solution-using-XOR
    public int run(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i = 0; i != len; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

}
