package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
@Deprecated
public class LeetCode_0118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        return run(numRows);
    }

    public static List<List<Integer>> run(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            call(result, i);
        }
        return result;
    }

    public static void call(List<List<Integer>> result, int row) {
        List<Integer> preList = null;
        if (row > 0) {
            preList = result.get(row - 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row + 1; i++) {
            if (i == 0 || i == row) {
                list.add(1);
                continue;
            }

            list.add(preList.get(i - 1) + preList.get(i));
        }
        result.add(list);
    }

}
