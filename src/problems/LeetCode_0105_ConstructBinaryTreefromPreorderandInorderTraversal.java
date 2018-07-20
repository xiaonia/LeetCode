package problems;

import shared.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode_0105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return run(preorder, inorder);
    }

    public TreeNode run(int[] preorder, int[] inorder) {
        return null;
    }

}
