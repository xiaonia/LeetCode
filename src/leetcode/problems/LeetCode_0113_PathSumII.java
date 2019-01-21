package leetcode.problems;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
@Deprecated
public class LeetCode_0113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return run(root, sum);
    }

    public static List<List<Integer>> run(TreeNode root, int sum) {
        return call(root, sum);
    }

    public static List<List<Integer>> call(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            }
            return result;
        }

        if (root.left != null) {
            result.addAll(call(root.left, sum - root.val));
        }

        if (root.right != null) {
            result.addAll(call(root.right, sum - root.val));
        }

        for (List<Integer> list : result) {
            list.add(0, root.val);
        }

        return result;
    }

}
