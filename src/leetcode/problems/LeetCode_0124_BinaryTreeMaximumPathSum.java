package leetcode.problems;

import leetcode.shared.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
@Deprecated
public class LeetCode_0124_BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        return run(root);
    }

    public static int run(TreeNode root) {
        return maxPathSumThroughRoot(root)[1];
    }

    public static int[] maxPathSumThroughRoot(TreeNode root) {
        if (root == null) {
            return null;
        }

        int[] result = new int[2];
        int[] leftChildResult = maxPathSumThroughRoot(root.left);
        int[] rightChildResult = maxPathSumThroughRoot(root.right);

        int leftPathSum = (leftChildResult == null? 0 : leftChildResult[0]) + root.val;
        int rightPathSum = (rightChildResult == null? 0 : rightChildResult[0]) + root.val;
        int maxPathSum = Math.max(leftPathSum, rightPathSum);
        maxPathSum = Math.max(maxPathSum, root.val);
        result[0] = maxPathSum;

        int rootPathSum = leftPathSum + rightPathSum - root.val;
        maxPathSum = Math.max(maxPathSum, rootPathSum);
        if (leftChildResult != null) {
            maxPathSum = Math.max(maxPathSum, leftChildResult[1]);
        }
        if (rightChildResult != null) {
            maxPathSum = Math.max(maxPathSum, rightChildResult[1]);
        }
        result[1] = maxPathSum;

        return result;
    }

}
