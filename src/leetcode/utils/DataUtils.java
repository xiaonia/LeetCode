package leetcode.utils;

import leetcode.shared.ListNode;
import leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataUtils {

    public static TreeNode createBinaryTree(Integer[] vals) {
        if (vals == null || vals.length == 0 || vals[0] == null) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(vals[0]);
        stack.addLast(root);
        Integer val = null;
        TreeNode parent = null;

        int index = 1;
        while (true) {
            if (stack.size() == 0) {
                break;
            }

            parent = stack.pollFirst();

            if (index >= vals.length) {
                break;
            }
            val = vals[index];
            if (val != null) {
                parent.left = new TreeNode(val);
                stack.addLast(parent.left);
            }
            index ++;

            if (index >= vals.length) {
                break;
            }
            val = vals[index];
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

    public static ListNode createListNode(Integer[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode node = head;
        for (int i = 1; i < vals.length; i++) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
        return head;
    }

}
