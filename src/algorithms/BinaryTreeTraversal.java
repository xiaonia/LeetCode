package algorithms;

import shared.TreeNode;

import java.util.List;

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

    }

    public static void inorderTraversalByStack(TreeNode root, List<Integer> list) {

    }

    public static void postorderTraversalByStack(TreeNode root, List<Integer> list) {

    }

}
