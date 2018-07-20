package problems;

import shared.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class LeetCode_0106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return run(inorder, postorder);
    }

    public TreeNode run(int[] inorder, int[] postorder) {
        return null;
    }

}
