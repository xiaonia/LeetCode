package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Given a binary tree, return the inorder traversal of its nodes' values. */
/*
Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */
@Deprecated
public class LeetCode_0094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.addLast(node);
                if (node.left != null) {
                    node = node.left;
                    continue;
                }
            }

            node = stack.pollLast();
            if (node == null) {
                break;
            }

            list.add(node.val);
            if (node.right != null) {
                node = node.right;
                continue;
            }
            node = null;
        }

        return list;
    }

}
