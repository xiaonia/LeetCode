package problems;

import shared.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
@Deprecated
public class LeetCode_0104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        return run(root);
    }

    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = run(root.left);
        int rightDepth = run(root.right);
        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        }
        return rightDepth + 1;
    }

}
