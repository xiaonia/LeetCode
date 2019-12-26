package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
@Deprecated
public class LeetCode_0145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        return run(root);
    }

    public static List<Integer> run(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalByStack(root, list);
        return list;
    }

    public static void postorderTraversalByStack(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            list.add(0, node.val);
            if (node.right != null) {
                if (node.left != null) {
                    stack.push(node.left);
                }
                node = node.right;
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    if (!stack.isEmpty()) {
                        node = stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void postorderTraversalByStackII(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> stateStack = new Stack<>();
        nodeStack.push(root);
        stateStack.push(0);

        TreeNode node = null;
        int state = 0;
        while (true) {
            if (nodeStack.isEmpty()) {
                break;
            }

            state = stateStack.pop();
            if (state == 0) { // none has push or chekced
                stateStack.push(1);
                node = nodeStack.peek().left;
                while (node != null) {
                    nodeStack.push(node);
                    stateStack.push(1);
                    node = node.left;
                }
            } else if (state == 1) { // left has push or is null
                stateStack.push(2);
                node = nodeStack.peek().right;
                while (node != null) {
                    nodeStack.push(node);
                    stateStack.push(1);
                    node = node.left;
                }
            } else { // right has push or is null
                node = nodeStack.pop();
                list.add(node.val);
            }
        }
    }

}
