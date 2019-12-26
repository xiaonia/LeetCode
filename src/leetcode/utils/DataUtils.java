package leetcode.utils;

import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataUtils {

    public static TreeNode createBinaryTree(Integer[] ints) {
        if (ints == null || ints.length == 0 || ints[0] == null) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(ints[0]);
        stack.addLast(root);
        Integer val = null;
        TreeNode parent = null;

        int index = 1;
        while (true) {
            if (stack.size() == 0) {
                break;
            }

            parent = stack.pollFirst();

            if (index >= ints.length) {
                break;
            }
            val = ints[index];
            if (val != null) {
                parent.left = new TreeNode(val);
                stack.addLast(parent.left);
            }
            index ++;

            if (index >= ints.length) {
                break;
            }
            val = ints[index];
            if (val != null) {
                parent.right = new TreeNode(val);
                stack.addLast(parent.right);
            }
            index ++;
        }

        return root;
    }

    public static List<String> createStringList(String[] strs) {
        List<String> list = null;
        if (strs != null && strs.length > 0) {
            list = new ArrayList<>();
            for (String str : strs) {
                list.add(str);
            }
        }
        return list;
    }

}
