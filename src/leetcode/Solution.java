package leetcode;

import leetcode.shared.TreeNode;
import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import leetcode.problems.*;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        //*
        TreeNode root = DataUtils.createBinaryTree(new Integer[]{1,2,3});

        DebugUtils.print(
                (new LeetCode_0130_SurroundedRegions()).run(
                        new char[][]{
                                {'X', 'X', 'X', 'X',},
                                {'X', 'O', 'O', 'X',},
                                {'X', 'X', 'O', 'X',},
                                {'X', 'O', 'X', 'X',},
                        }
                )
        );
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
