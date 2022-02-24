package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * 221. Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class LeetCode_0221 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0221().maximalSquare(
                        new char[][] {
                                { '1', '0', '1', '0', '0' },
                                { '1', '0', '1', '1', '1' },
                                { '1', '1', '1', '1', '1' },
                                { '1', '0', '0', '1', '0' }
                        }
                )
        );
    }

    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {
                maxLength = Math.max(maxLength, maximalSquare(matrix, column, row));
            }
        }
        return maxLength * maxLength;
    }

    public int maximalSquare(char[][] matrix, int column, int row) {
        if (matrix[column][row] == '0') {
            return 0;
        }

        int length = 0;
        while (column + length < matrix.length && row + length < matrix[column].length) {
            for (int i = 0; i <= length; i++) { // horizontal
                if (matrix[column + length][row + i] == '0') {
                    return length;
                }
            }

            for (int j = 0; j < length; j++) { // vertical
                if (matrix[column + j][row + length] == '0') {
                    return length;
                }
            }

            length++;
        }

        return length;
    }


}
