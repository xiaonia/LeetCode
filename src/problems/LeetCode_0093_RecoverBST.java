package problems;

import shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class LeetCode_0093_RecoverBST {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        findErrorNode(root, list);

        list.add(root);
        TreeNode current = null;
        TreeNode parent = null;
        while (list.size() > 0) {
            current = list.remove(list.size() - 1);

            if (current.left != null) {

            }

            if ((current.left != null && current.left.val > current.val)
                    || (current.right != null && current.right.val < current.val)) {


            }

            if (current.left != null) {
                list.add(current.left);
            }
            if (current.right != null) {
                list.add(current.right);
            }
        }

    }

    public static void findErrorNode(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.val > root.val) {
            if (root.left.right != null && root.left.val > root.left.right.val) {
                list.add(root.left);
            } else {
                list.add(root);
            }
        }

        if (root.right != null && root.right.val < root.val) {
            if (root.right.left != null && root.right.val < root.right.left.val) {
                list.add(root.right);
            } else {
                list.add(root);
            }
        }

        findErrorNode(root.left, list);

        findErrorNode(root.right, list);
    }

    static class NodeHolder {

        public TreeNode parent;

        public TreeNode child;

    }

}
