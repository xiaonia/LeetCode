package leetcode.utils;

import leetcode.shared.TreeNode;
import leetcode.algorithms.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DebugUtils {

    public static void print(Object obj) {
        if (obj instanceof TreeNode) {
            printTreeNode((TreeNode) obj);
        } else {
            printObject(toString(obj));
        }
    }

    public static void printObject(Object obj) {
        System.out.println(obj);
    }

    public static void printTreeNode(TreeNode treeNode) {
        List<Integer> list = new ArrayList<>();
        BinaryTreeTraversal.inorderTraversalByRecursion(treeNode, list);
        print(list);
    }

    public static String toString(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("[");
        for (Object item : list) {
            sb.append(" ");
            sb.append(toString(item));
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof List) {
            return toString((List) obj);
        }
        return obj.toString();
    }

}
