package utils;

import shared.TreeNode;

import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DebugUtils {

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print(List<Object> list) {
        DebugUtils.print("[");
        for (Object item : list) {
            DebugUtils.print(item);
            DebugUtils.print(", ");
        }
        DebugUtils.print("]");
    }

    public static void print(TreeNode treeNode) {

    }

}
