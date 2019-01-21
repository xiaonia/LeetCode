package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
@Deprecated
public class LeetCode_0114_FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        call(root, null);
    }

    //非递归
    public static void run(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        TreeNode next = root;
        while (true) {
            if (next == null) {
                if (stack.size() == 0) {
                    break;
                }
                next = stack.pop();
            }

            if (node != null) {
                node.right = next;
                node.left = null;
            }
            node = next;
            if (node.right != null) {
                stack.push(node.right);
            }
            next = node.left;
        }
    }

    //递归
    public static TreeNode call(TreeNode root, TreeNode next) {
        if (root == null) {
            return next;
        }
        TreeNode node = call(root.right, next);
        node = call(root.left, node);
        root.right = node;
        root.left = null;
        return root;
    }

}
