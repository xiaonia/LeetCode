package problems;

import shared.TreeNode;

/**
 *Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 *  such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
@Deprecated
public class LeetCode_0112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return run(root, sum);
    }

    public static boolean run(TreeNode root, int sum) {
        return call(root, sum);
    }

    public static boolean call(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

        if (root.left == null) {
            return call(root.right, sum - root.val);
        }

        if (root.right == null) {
            return call(root.left, sum - root.val);
        }

        return call(root.left, sum - root.val) || call(root.right, sum - root.val);
    }

}
