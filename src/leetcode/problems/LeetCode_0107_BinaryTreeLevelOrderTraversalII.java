package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
@Deprecated
public class LeetCode_0107_BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return run(root);
    }

    public static List<List<Integer>> run(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        help(root, result, 1);
        return result;
    }

    public static void help(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }
        while (result.size() < level) {
            result.add(0, new ArrayList<>());
        }
        List<Integer> list = result.get(result.size() - level);
        list.add(root.val);
        help(root.left, result, level + 1);
        help(root.right, result, level + 1);
    }

}
