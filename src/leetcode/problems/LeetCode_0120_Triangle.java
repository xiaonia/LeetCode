package leetcode.problems;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
@Deprecated
public class LeetCode_0120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int height = triangle.size();
        final Integer[] tmp = new Integer[(1 + height) * height / 2];

        List<Integer> list = triangle.get(height - 1);
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            count = Math.min(count,
                    run(triangle, tmp, height - 1, i));
        }
        return count;
    }

    public int run(final List<List<Integer>> triangle, final Integer[] tmp, final int column, final int row) {
        if (column < 0 || row < 0) {
            return 0;
        }

        int index = (1 + column) * column / 2 + row;
        if (tmp[index] != null) {
            return tmp[index];
        }

        int count = 0;
        if (row == 0) {
            count = run(triangle, tmp, column - 1, row);
        }
        else if (row == column) {
            count = run(triangle, tmp, column - 1, row - 1);
        } else {
            count = Math.min(
                    run(triangle, tmp, column - 1, row - 1),
                    run(triangle, tmp, column - 1, row)
            );
        }

        List<Integer> list = triangle.get(column);
        count += list.get(row);
        tmp[index] = count;
        return count;
    }

}
