package leetcode.problems;

/**
 * https://leetcode.com/problems/dungeon-game/
 *
 * 174. Dungeon Game
 *
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
@Deprecated
public class LeetCode_0174 {

    public int calculateMinimumHP(int[][] dungeon) {
        return run(dungeon);
    }

    public static int run(int[][] dungeon) {
        if (dungeon == null) {
            return 0;
        }

        if (dungeon.length == 0) {
            return 0;
        }

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] tmp = new int[m][n];
        if (dungeon[m - 1][n - 1] <= 0) {
            tmp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;
        } else {
            tmp[m - 1][n - 1] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (dungeon[m - 1][i] <= 0) {
                tmp[m - 1][i] = Math.max(tmp[m - 1][i + 1], 1) + -dungeon[m - 1][i];
            }
            else {
                tmp[m - 1][i] = Math.max(tmp[m - 1][i + 1] - dungeon[m - 1][i], 0);
            }
        }

        for (int j = m - 2; j >= 0; j--) {
            if (dungeon[j][n - 1] <= 0) {
                tmp[j][n - 1] = Math.max(tmp[j + 1][n - 1], 1) + -dungeon[j][n - 1];
            }
            else {
                tmp[j][n - 1] = Math.max(tmp[j + 1][n - 1] - dungeon[j][n - 1], 0);
            }
        }

        for (int j = m - 2; j >= 0; j--) {
            for (int i = n - 2; i >= 0; i--) {
                if (dungeon[j][i] <= 0) {
                    tmp[j][i] = Math.min(Math.max(tmp[j][i + 1], 1), Math.max(tmp[j + 1][i], 1)) + -dungeon[j][i];
                }
                else {
                    tmp[j][i] = Math.max(Math.min(tmp[j][i + 1], tmp[j + 1][i]) - dungeon[j][i], 0);
                }
            }
        }

        if (tmp[0][0] == 0) {
            return 1;
        }
        return tmp[0][0];
    }

}
