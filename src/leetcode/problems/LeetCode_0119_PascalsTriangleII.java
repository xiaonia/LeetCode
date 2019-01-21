package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *[
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
@Deprecated
public class LeetCode_0119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        return run(rowIndex);
    }

    public static List<Integer> run(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            call(result, i);
        }
        return result;
    }

    public static void call(List<Integer> list, int rowIndex) {
        if (rowIndex == 0) {
            list.add(1);
            return;
        }
        if (rowIndex == 1) {
            list.add(1);
            return;
        }
        list.add(1, list.get(0) + list.get(1));
        for (int i = 2; i < rowIndex; i++) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
    }

}
