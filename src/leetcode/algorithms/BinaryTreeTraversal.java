package leetcode.algorithms;

import leetcode.shared.TreeNode;

import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class BinaryTreeTraversal {

    public static void preorderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalByRecursion(root.left, list);
        preorderTraversalByRecursion(root.right, list);
    }

    public static void inorderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversalByRecursion(root.left, list);
        list.add(root.val);
        inorderTraversalByRecursion(root.right, list);
    }

    public static void postorderTraversalByRecursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorderTraversalByRecursion(root.left, list);
        postorderTraversalByRecursion(root.right, list);
        list.add(root.val);
    }

    //***********************************************************************

    public static void preorderTraversalByStack(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;

        while (true) {
            list.add(node.val);
            if (node.left != null) {
                if (node.right != null) {
                    nodeStack.push(node.right);
                }
                node = node.left;
            } else {
                if (node.right != null) {
                    node = node.right;
                } else {
                    if (!nodeStack.isEmpty()) {
                        node = nodeStack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void inorderTraversalByStack(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }

        while (true) {
            if (nodeStack.isEmpty()) {
                break;
            }

            node = nodeStack.pop();
            list.add(node.val);
            node = node.right;
            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }
        }
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
