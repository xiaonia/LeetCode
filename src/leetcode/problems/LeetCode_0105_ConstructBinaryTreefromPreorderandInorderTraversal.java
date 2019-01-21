package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
@Deprecated
public class LeetCode_0105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return run(preorder, inorder);
    }

    public static TreeNode run(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int index = 1;
        TreeNode parent = root;
        TreeNode child = null;
        while (index < preorder.length) {
            child = new TreeNode(preorder[index]);
            if (map.get(preorder[index]) < map.get(parent.val)) {
                parent.left = child;
                stack.push(parent);
            }
            else {
                while (stack.size() > 0 && stack.peek() != null
                        && map.get(preorder[index]) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = child;
            }
            parent = child;
            index ++;
        }

        return root;
    }

}
