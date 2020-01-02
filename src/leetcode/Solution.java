package leetcode;

import leetcode.algorithms.MorrisTraversal;
import leetcode.shared.TreeNode;
import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import leetcode.problems.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        //*
        TreeNode input = DataUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //int[][] input = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        //int[][] input = new int[][]{{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
        //String input = "aab";

        List<Integer> list = new ArrayList<>();
        MorrisTraversal.postorderTraversal(input, list);
        DebugUtils.print(
                list
        );
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
