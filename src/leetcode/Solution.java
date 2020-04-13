package leetcode;

import leetcode.shared.ListNode;
import leetcode.shared.TreeNode;
import leetcode.utils.DataUtils;
import leetcode.utils.DebugUtils;

import leetcode.problems.*;

public class Solution {

    public static void main(String[] args) {
        DebugUtils.print("processing solution...");
        long start = System.currentTimeMillis();

        ListNode listNode = DataUtils.createListNode(new Integer[]{-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115});
        //*
        TreeNode treeNode = DataUtils.createBinaryTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //int[][] input = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        //int[][] input = new int[][]{{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
        //String input = "aab";

        //List<Integer> list = new ArrayList<>();
        //MorrisTraversal.postorderTraversal(input, list);
        String str = "worddwordbestwordgoodgoodgoodbestwordword";
        String[] words = new String[]{"word","ordd","best","word"};
        DebugUtils.print(
                LeetCode_0188.run(
                        2, new int[]{1,2,4,2,5,7,2,4,9,0,9}
                )
        );
        //*/

        DebugUtils.print("time cost: " + (System.currentTimeMillis() - start) + " mills");
    }

}
