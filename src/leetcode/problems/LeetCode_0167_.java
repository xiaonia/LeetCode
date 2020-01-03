package leetcode.problems;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class LeetCode_0167_ {

    public int[] twoSum(int[] numbers, int target) {
        return run(numbers, target);
    }

    public static int[] run(int[] numbers, int target) {
        int n = numbers.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > target) {
                break;
            }
            j = binarySearch(numbers, i + 1, n - 1, target - numbers[i]);
            if (j > 0) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static int binarySearch(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        if (numbers[right] == target) {
            return right;
        }
        int mid = (left + right) / 2;
        while (true) {
            if (numbers[mid] == target) {
                return mid;
            }
            if (left == mid) {
                break;
            }
            if (numbers[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public int[] twoSum2(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }


}
