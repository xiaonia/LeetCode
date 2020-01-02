package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * 99. Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 *
 * 二叉搜索树按【中序遍历】是【有序】数组
 *
 */
@Deprecated
public class LeetCode_0099 {

    public void recoverTree(TreeNode root) {
        run(root);
    }

    public static void run(TreeNode root) {
        TreeNode firstChild = null;
        List<TreeNode> firstList = new ArrayList<>();
        TreeNode secondChild = null;
        List<TreeNode> secondList = new ArrayList<>();
        TreeNode node = root;
        firstList.add(node);
        secondList.add(node);

        if (checkBST(node.left, firstList)) {
            firstChild = firstList.get(firstList.size() - 2);
        }

        if (checkBST(node.right, secondList)) {
            secondChild = secondList.get(secondList.size() - 2);
        }

        if (firstChild != null && secondChild != null) {
            swapNode(firstChild, secondChild);
            return;
        }

        if (firstChild != null) {
            node = firstList.get(firstList.size() - 1);
            if (firstChild.val > node.val) {
                secondList.clear();
                secondList.add(node);
                if (checkBST(node.right, secondList)) {
                    secondChild = secondList.get(secondList.size() - 2);
                    swapNode(firstChild, secondChild);
                    return;
                }
                swapNode(node, findMax(node.left));
            } else {
                secondList.clear();
                secondList.add(node);
                if (checkBST(node.left, secondList)) {
                    secondChild = secondList.get(secondList.size() - 2);
                    swapNode(firstChild, secondChild);
                    return;
                }
                swapNode(node, findMin(node.right));
            }
            return;
        }

        if (secondChild != null) {
            node = secondList.get(secondList.size() - 1);
            if (secondChild.val > node.val) { // is left child node
                firstList.clear();
                firstList.add(node);
                if (checkBST(node.right, firstList)) {
                    firstChild = firstList.get(firstList.size() - 2);
                    swapNode(firstChild, secondChild);
                    return;
                }
                swapNode(node, findMax(node.left));
            } else {
                firstList.clear();
                firstList.add(node);
                if (checkBST(node.left, firstList)) {
                    firstChild = firstList.get(firstList.size() - 2);
                    swapNode(firstChild, secondChild);
                    return;
                }
                swapNode(node, findMin(node.right));
            }
        }
    }

    public static boolean checkBST(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return false;
        }

        list.add(node);
        TreeNode parent = null;
        TreeNode child = null;

        for (int i = 0; i < list.size() - 1; i++) {
            parent = list.get(i);
            child = list.get(i + 1);
            if (parent.left == child) { // is left child node
                if (node.val > parent.val) {
                    list.add(parent);
                    return true;
                }
            } else { // is right child node
                if (node.val < parent.val) {
                    list.add(parent);
                    return true;
                }
            }
        }

        if (checkBST(node.left, list)) {
            return true;
        }

        if (checkBST(node.right, list)) {
            return true;
        }

        list.remove(node);
        return false;
    }

    private static TreeNode findMin(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = root;
        TreeNode node = root;
        while (true) {
            if (node.val < result.val) {
                result = node;
            }
            if (node.left != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
            else if (node.right != null) {
                node = node.right;
            }
            else if (!stack.isEmpty()) {
                node = stack.pop();
            } else {
                break;
            }
        }
        return result;
    }

    private static TreeNode findMax(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = root;
        TreeNode node = root;
        while (true) {
            if (node.val > result.val) {
                result = node;
            }
            if (node.left != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
            else if (node.right != null) {
                node = node.right;
            }
            else if (!stack.isEmpty()) {
                node = stack.pop();
            } else {
                break;
            }
        }
        return result;
    }

    private static void swapNode(TreeNode firstChild, TreeNode secondChild) {
        //System.out.println("[" + firstChild.val + ", " + secondChild.val + "]");
        int val = firstChild.val;
        firstChild.val = secondChild.val;
        secondChild.val = val;
    }

}
