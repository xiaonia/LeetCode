package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
//使用栈辅助，亦可用分治法+递归实现
    @Deprecated
public class LeetCode_0106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return run(inorder, postorder);
    }

    public static TreeNode run(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        int index = inorder.length - 1 - 1;
        TreeNode parent = root;
        TreeNode child = null;
        while (index >= 0) {
            child = new TreeNode(postorder[index]);
            if (map.get(child.val) > map.get(parent.val)) {
                parent.right = child;
                stack.addLast(parent);
            } else {
                while (stack.peekLast() != null
                        && map.get(child.val) < map.get(stack.peekLast().val)) {
                    parent = stack.pollLast();
                }
                parent.left = child;
            }
            parent = child;
            index --;
        }

        return root;
    }

}
