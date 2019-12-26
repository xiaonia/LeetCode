package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
@Deprecated
public class LeetCode_0144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        return run(root);
    }

    public static List<Integer> run(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalByStack(root, list);
        return list;
    }

    public static void preorderTraversalByStack(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        TreeNode node = null;
        while (true) {
            if (nodeStack.isEmpty()) {
                break;
            }

            node = nodeStack.pop();
            list.add(node.val);
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
    }

}
