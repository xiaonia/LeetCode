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
        //TreeNode root = DataUtils.createBinaryTree(new Integer[]{1,null,2,3,null});
        DebugUtils.print(LeetCode_0108_ConvertSortedArraytoBinarySearchTree.run(new int[]{-10,-3,0,5,9}));
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
