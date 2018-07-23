package problems;

import shared.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
@Deprecated
public class LeetCode_0111_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        return run(root);
    }

    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return 1 + run(root.right);
        }

        if (root.right == null) {
            return 1 + run(root.left);
        }

        return 1 + Math.min(run(root.left), run(root.right));
    }

}
