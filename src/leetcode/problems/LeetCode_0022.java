package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * 22. Generate Parentheses

 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
@Deprecated
public class LeetCode_0022 {

    private static final String LP = "(";
    private static final String RP = ")";

    public List<String> generateParenthesis(int n) {
        return run(n);
    }

    public static List<String> run(int n) {
        List<String> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        int start = 0;
        int end = 0;
        int leftCount = 0;
        int rightCount = 0;
        int maxCount = n * 2;
        int totalCount = 0;
        List<String>[] listArray = new List[n + 1];

        List<String> list = new ArrayList<>();
        list.add(LP);
        listArray[0] = list;
        totalCount ++;
        while (totalCount < maxCount) {
            start = Math.min(totalCount, n);
            end = (totalCount -1) / 2;
            for (int i = start ; i > end; i--) {
                leftCount = i;
                rightCount = totalCount - leftCount;
                if (leftCount < n) {
                    list = listArray[leftCount];
                    if (list == null) {
                        list = new ArrayList<>();
                        listArray[leftCount] = list;
                    }
                    for (String item : listArray[leftCount - 1]) {
                        list.add(item + LP);
                    }
                }

                if (leftCount != rightCount && rightCount < n){
                    list = new ArrayList<>();
                    for (String item : listArray[leftCount - 1]) {
                        list.add(item + RP);
                    }
                    listArray[leftCount - 1] = list;
                }
            }
            totalCount ++;
        }
        return listArray[n - 1];
    }

}
