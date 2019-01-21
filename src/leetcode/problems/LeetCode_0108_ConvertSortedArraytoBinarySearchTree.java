package leetcode.problems;

import leetcode.shared.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
@Deprecated
public class LeetCode_0108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return run(nums);
    }

    public static TreeNode run(int[] nums) {
        return call(nums, 0, nums.length - 1);
    }

    public static TreeNode call(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        if (end == start) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2 + (start + end) % 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = call(nums, start, mid - 1);
        node.right = call(nums, mid + 1, end);
        return node;
    }

}
