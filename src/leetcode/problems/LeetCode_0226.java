package leetcode.problems;

import leetcode.shared.TreeNode;
import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * 226. Invert Binary Tree
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class LeetCode_0226 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0226().invertTree2(
                        DataUtils.createBinaryTree(
                                new Integer[]{
                                        4, 1, null
                                }
                        )
                )
        );
        DebugUtils.print(
                new LeetCode_0226().invertTree(
                        DataUtils.createBinaryTree(
                                new Integer[]{
                                        4, 2, 7, null, 3, 6, null
                                }
                        )
                )
        );
        DebugUtils.print(
                new LeetCode_0226().invertTree2(
                        DataUtils.createBinaryTree(
                                new Integer[]{
                                        4, 2, 7, null, 3, 6, null
                                }
                        )
                )
        );
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode parent;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            while (true) {
                if (stack.isEmpty()) {
                    return root;
                }

                parent = stack.peek();
                if (/*node == null || */node == parent.left) {
                    node = parent.right;
                    if (node != null) {
                        break;
                    }
                }

                if (node == null || node == parent.right) {
                    parent.right = parent.left;
                    parent.left = node;
                    node = stack.pop();
                }
            }
        }
    }

}
