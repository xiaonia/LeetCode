package leetcode.problems;

import leetcode.shared.TreeNode;
import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * 222. Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 *  *     1
 *  *    / \
 *  *   2   3
 *  *  / \  / \
 *  * 4  5 6   7
 *
 *  *  *     1
 *  *  *    / \
 *  *  *   2   3
 *  *  *  / \
 *  *  * 4  5
 *
 * Output: 6
 */
public class LeetCode_0222 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1})
                )
        );
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1,2})
                )
        );
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1,2,3})
                )
        );
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1,2,3,4,5,6})
                )
        );
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1,2,3,4,5,6,7})
                )
        );
        DebugUtils.print(
                new LeetCode_0222().countNodes(
                        DataUtils.createBinaryTree(new Integer[]{1,2,3,4,5})
                )
        );
    }

    // DFS
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leafCount = 0;
        int maxDepth = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode parent;
        while (true) {
            while (!stack.isEmpty()) {
                parent = stack.peek();
                if (parent.right == node) {
                    node = parent.left;
                    break;
                }

                if (parent == root) {
                    return ((int) Math.pow(2, maxDepth)) - 1;
                }

                node = stack.pop();
            }

            while (node.left != null && node.right != null) {
                stack.push(node);
                node = node.right;
            }

            if (maxDepth == 0) {
                maxDepth = stack.size() + 1;
            }

            if (node.left != null) {
                return ((int) Math.pow(2, stack.size() + 2)) - 1 - leafCount * 2 - 1;
            }

            if (stack.size() >= maxDepth) {
                return ((int) Math.pow(2, stack.size() + 1)) - 1 - leafCount * 2;
            }

            leafCount++;
        }
    }

}
