package problems;

import shared.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
@Deprecated
public class LeetCode_0110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return run(root);
    }

    public static boolean run(TreeNode root) {
        return depth(root) >= 0;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth < 0 || rightDepth < 0
                || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
