package leetcode;

import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import leetcode.problems.*;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        //*
        //TreeNode root = DataUtils.createBinaryTree(new Integer[]{1,null,2,3,null});
        DebugUtils.print(
                (new LeetCode_0135_Candy()).run(
                        new int[] {
                                1,0,2
                        }
                )
        );
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
