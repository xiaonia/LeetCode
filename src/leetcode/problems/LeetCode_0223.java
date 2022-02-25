package leetcode.problems;

import leetcode.utils.DebugUtils;

/**
 * https://leetcode.com/problems/rectangle-area/
 *
 * 223. Rectangle Area
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class LeetCode_0223 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0223().computeArea(
                        0, 0,
                        0, 0,
                        -1, -1,
                        1, 1
                )
        );
        DebugUtils.print(
                new LeetCode_0223().computeArea(
                        -3, 0,
                        3, 4,
                        0, -1,
                        9, 2
                )
        );

    }

    public int computeArea(
            int lbx1, int lby1, int rtx1, int rty1,
            int lbx2, int lby2, int rtx2, int rty2
    ) {
        int left = Math.max(lbx1, lbx2);
        int top = Math.min(rty1, rty2);
        int right = Math.min(rtx1, rtx2);
        int bottom = Math.max(lby1, lby2);
        int overlay = 0;
        if (left <= right && top >= bottom) {
            overlay = (right - left) * (top - bottom);
        }
        int total = (rtx1 - lbx1) * (rty1 - lby1) + (rtx2 - lbx2) * (rty2 - lby2);
        return total - overlay;
    }

}
