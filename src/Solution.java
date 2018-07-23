import algorithms.BinaryTreeTraversal;
import problems.*;
import utils.DataUtils;
import utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        //*
        DebugUtils.print(LeetCode_0112_PathSum.run(
                DataUtils.createBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}),
                22
        ));
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
