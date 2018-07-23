import algorithms.BinaryTreeTraversal;
import problems.*;
import shared.TreeNode;
import utils.DataUtils;
import utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        //*
        TreeNode root = DataUtils.createBinaryTree(new Integer[]{1,null,2,3,null});
        LeetCode_0114_FlattenBinaryTreetoLinkedList.call(root, null);
        DebugUtils.print(root);
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
