package leetcode.problems;

import leetcode.shared.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
@Deprecated
public class LeetCode_0129_SumRoottoLeafNumbers {

    private int mResult = 0;

    public int sumNumbers(TreeNode root) {
        return run(root);
    }

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        call(root);

        return mResult;
    }

    private int[] call(TreeNode root) {
        if (root.left == null && root.right == null) {
            mResult += root.val;
            return new int[]{0};
        }

        int[] arrayLeft = null;
        if (root.left != null) {
            arrayLeft = call(root.left);
        }
        int[] arrayRight = null;
        if (root.right != null) {
            arrayRight = call(root.right);
        }
        int[] arrayRoot = new int[
                (arrayLeft == null? 0 : arrayLeft.length)
                + (arrayRight == null? 0 : arrayRight.length)];

        int i = 0;
        if (arrayLeft != null) {
            for (int value : arrayLeft) {
                arrayRoot[i] = value + 1;
                i++;
            }
        }
        if (arrayRight != null) {
            for (int value : arrayRight) {
                arrayRoot[i] = value + 1;
                i++;
            }
        }

        for (int value : arrayRoot) {
            mResult += (root.val * Math.pow(10, value));
        }

        return arrayRoot;
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }

}
