package utils;

import shared.TreeNode;

import java.util.LinkedList;

public class DataUtils {

    public static TreeNode createBinaryTree(Integer[] ints) {
        if (ints == null || ints.length == 0 || ints[0] == null) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(ints[0]);
        stack.addLast(root);
        Integer leftVal = null;
        Integer rightVal = null;
        TreeNode parent = null;
        TreeNode child = null;
        int index = 1;
        while (index < ints.length - 1) {
            if (stack.size() == 0) {
                break;
            }
            leftVal = ints[index];
            rightVal = ints[index + 1];
            parent = stack.pollFirst();
            if (leftVal != null) {
                child = new TreeNode(leftVal);
                parent.left = child;
                stack.addLast(child);
            }
            if (rightVal != null) {
                child = new TreeNode(rightVal);
                parent.right = child;
                stack.addLast(child);
            }
            index += 2;
        }
        return root;
    }

}
