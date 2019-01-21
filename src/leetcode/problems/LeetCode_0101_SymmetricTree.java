package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
@Deprecated
public class LeetCode_0101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return run(root);
    }

    public boolean run(TreeNode root) {
        LinkedList<TreeNode> leftSrack = new LinkedList<>();
        LinkedList<TreeNode> rightStack = new LinkedList<>();
        leftSrack.addLast(root);
        rightStack.addLast(root);
        TreeNode leftNode;
        TreeNode rightNode;
        while (true) {
            if (leftSrack.size() == 0 && rightStack.size() == 0) {
                return true;
            }

            leftNode = leftSrack.pollFirst();
            rightNode = rightStack.pollFirst();

            if (rightNode == null && leftNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }

            leftSrack.addLast(leftNode.left);
            leftSrack.addLast(leftNode.right);
            rightStack.addLast(rightNode.right);
            rightStack.addLast(rightNode.left);
        }
    }

}
