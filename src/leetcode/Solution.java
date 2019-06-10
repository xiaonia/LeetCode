package leetcode;

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
        TreeNode root = DataUtils.createBinaryTree(new Integer[]{1,2,3});

        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");

        DebugUtils.print(
                (new LeetCode_0140_WordBreakII()).run(
                        "pineapplepenapple",
                        wordDict
                )
        );
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
