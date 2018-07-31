package problems;

import shared.TreeLinkNode;

import java.util.LinkedList;

/**
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
@Deprecated
public class LeetCode_0116_PopulatingNextRightPointersinEachNode {

    //广度优先
    public void connect(TreeLinkNode root) {
        connectRecursive(root);
    }

    public void connectRecursive(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null && root.right != null) {
                root.right.next = root.next.left;
            }
        }

        connectRecursive(root.left);
        connectRecursive(root.right);
    }

    //广度优先
    public void connectQueue(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.addLast(root);
        int size = 0;
        int count = 0;
        TreeLinkNode preNode = null;
        TreeLinkNode nextNode = null;
        while (true) {
            if (preNode != null) {
                preNode.next = null;
            }
            preNode = null;
            count = 0;
            size = queue.size();
            if (size == 0) {
                break;
            }
            while (count < size) {
                nextNode = queue.pollFirst();
                if (preNode != null) {
                    preNode.next = nextNode;
                }
                preNode = nextNode;
                if (preNode.left != null) {
                    queue.addLast(preNode.left);
                }
                if (preNode.right != null) {
                    queue.addLast(preNode.right);
                }
                count ++;
            }
        }
    }

}
