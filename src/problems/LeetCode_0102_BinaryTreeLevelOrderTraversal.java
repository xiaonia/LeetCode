package problems;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
@Deprecated
public class LeetCode_0102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return run(root);
    }

    public List<List<Integer>> run(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.addLast(root);
        TreeNode node = null;
        int size = 0;
        int count = 0;
        List<Integer> list = null;
        while (true) {
            size = nodeStack.size();
            if (size == 0) {
                break;
            }
            list = new ArrayList<>();
            count = 0;
            while (count < size) {
                node = nodeStack.pollFirst();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        nodeStack.addLast(node.left);
                    }
                    if (node.right != null) {
                        nodeStack.addLast(node.right);
                    }
                }
                count++;
            }
            result.add(list);
        }
        return result;
    }

}
