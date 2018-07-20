package problems;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
@Deprecated
public class LeetCode_0103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return run(root);
    }

    public List<List<Integer>> run(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.addLast(root);
        List<Integer> list = null;
        TreeNode node = null;
        int size = 0;
        int count = 0;
        boolean r2l = false;
        while (true) {
            size = nodeStack.size();
            if (size == 0) {
                break;
            }
            count = 0;
            list = new ArrayList<>();
            while (count < size) {
                node = nodeStack.pollFirst();
                if (node != null) {
                    list.add(node.val);
                    if (r2l) {
                        if (node.right != null) {
                            nodeStack.add(size - count - 1, node.right);
                        }
                        if (node.left != null) {
                            nodeStack.add(size - count - 1, node.left);
                        }
                    } else {
                        if (node.left != null) {
                            nodeStack.add(size - count - 1, node.left);
                        }
                        if (node.right != null) {
                            nodeStack.add(size - count - 1, node.right);
                        }
                    }
                }

                count ++;
            }
            result.add(list);
            r2l = !r2l;
        }
        return result;
    }

}
