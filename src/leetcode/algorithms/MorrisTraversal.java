package leetcode.algorithms;

import leetcode.shared.TreeNode;

import java.util.List;

/**
 *                             1
 *                       /           \
 *                      2             3
 *                    / \            / \
 *                  4    5         6    7
 *                / \   / \       /    / \
 *               8  9 10  11    12   13  14
 *
 *  @link https://www.cnblogs.com/anniekim/archive/2013/06/15/morristraversal.html
 */
public class MorrisTraversal {

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        TreeNode node = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    list.add(cur.val); //
                    node.right = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    cur = cur.right;
                }
                continue;
            }

            list.add(cur.val); //
            cur = cur.right;
        }
    }

    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        TreeNode node = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    list.add(cur.val); //
                    cur = cur.right;
                }
                continue;
            }

            list.add(cur.val); //
            cur = cur.right;
        }
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        TreeNode node = null;
        TreeNode cur = root;

        while (true) {
            if (cur.left != null) {
                node = cur.left;
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    reverseTraversalRight(cur.left, list);
                    cur = cur.right;
                }
                continue;
            }

            if (cur.right == null) {
                break;
            }
            cur = cur.right;
        }

        reverseTraversalRight(root, list);
    }

    private static void reverseTraversalRight(TreeNode root, List<Integer> list) {
        TreeNode head = root;
        TreeNode tail = head;
        TreeNode next = tail.right;
        while (next != null) {
            tail.right = next.right;
            next.right = head;
            head = next;
            next = tail.right;
        }

        tail = head;
        next = tail.right;
        list.add(head.val);
        while (next != null) {
            tail.right = next.right;
            next.right = head;
            head = next;
            list.add(head.val);
            next = tail.right;
        }
    }

}
