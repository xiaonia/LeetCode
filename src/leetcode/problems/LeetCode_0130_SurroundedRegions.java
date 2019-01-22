package leetcode.problems;

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
@Deprecated
public class LeetCode_0130_SurroundedRegions {

    private static final char CHAR_X = 'X';
    private static final char CHAR_O = 'O';

    public void solve(char[][] board) {
        run(board);
    }

    public char[][] run(char[][] board) {
        if (board == null || board.length < 3) {
            return board;
        }

        final int[][] cache = new int[board.length][board[0].length];

        final Stack<Integer> stackI = new Stack<>();
        final Stack<Integer> stackJ = new Stack<>();
        int i = 0;
        int j = 0;
        int lengthI = board.length;
        int lengthJ = board[0].length;
        while (j < lengthJ) {
            if (board[i][j] == CHAR_O) {
                stackI.push(i);
                stackJ.push(j);
            }
            j ++;
        }
        j --;

        while (i < lengthI) {
            if (board[i][j] == CHAR_O) {
                stackI.push(i);
                stackJ.push(j);
            }
            i ++;
        }
        i--;

        while (j >= 0) {
            if (board[i][j] == CHAR_O) {
                stackI.push(i);
                stackJ.push(j);
            }
            j --;
        }
        j++;

        while (i > 0) {
            if (board[i][j] == CHAR_O) {
                stackI.push(i);
                stackJ.push(j);
            }
            i --;
        }
        i++;

        Integer eI = null;
        Integer eJ = null;
        while (true) {
            if (stackI.empty() || stackJ.empty()) {
                break;
            }

            eI = stackI.pop();
            eJ = stackJ.pop();
            if (eI == null || eJ == null) {
                continue;
            }

            if (cache[eI][eJ] == 1) {
                continue;
            }

            if (board[eI][eJ] != CHAR_O) {
                //cache[eI][eJ] = 0;
                continue;
            }

            cache[eI][eJ] = 1;//mark

            if (eI - 1 > 0) {
                stackI.push(eI - 1);
                stackJ.push(eJ);
            }

            if (eI + 1 < lengthI) {
                stackI.push(eI + 1);
                stackJ.push(eJ);
            }

            if (eJ - 1 > 0) {
                stackI.push(eI);
                stackJ.push(eJ - 1);
            }

            if (eJ + 1 < lengthJ) {
                stackI.push(eI);
                stackJ.push(eJ + 1);
            }
        }

        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[m].length; n++) {
                if (board[m][n] == CHAR_O && cache[m][n] != 1) {
                    board[m][n] = CHAR_X;
                }
            }
        }

        return board;
    }

}
