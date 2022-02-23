package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * 218. The Skyline Problem
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * Buildings Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class LeetCode_0218 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0218().getSkyline(
                        new int[][]{
                                {2, 9, 10},
                                {3, 7, 15},
                                {5, 12, 12},
                                {15, 20, 10},
                                {19, 24, 8}
                        }
                )
        );
        DebugUtils.print(
                new LeetCode_0218().getSkyline(
                        new int[][]{
                                {0, 2, 3},
                                {2, 5, 3}
                        }
                )
        );
    }

    // 区间合并
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> lists = new ArrayList<>();
        if (buildings.length == 0) {
            return lists;
        }

        int start = buildings[0][0];
        int end = buildings[0][1];
        for (int[] building : buildings) {
            end = Math.max(end, building[1]);
        }

        int left = start;
        int right = left;
        int top = 0;
        int index = 0;
        while (left < end) {
            top = 0;
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i][0] <= left && left < buildings[i][1]) {
                    if (buildings[i][2] > top) {
                        index = i;
                        top = buildings[i][2];
                        right = buildings[i][1];
                    }
                } else if (buildings[i][0] > left) {
                    index = i;
                    break;
                }
            }

            if (top == 0) {
                for (int i = index; i < buildings.length; i++) {
                    if (buildings[i][0] > left) {
                        right = buildings[i][0];
                        break;
                    }
                }
            } else {
                for (int i = index; i < buildings.length; i++) {
                    if (buildings[i][0] <= right && buildings[i][1] > left) {
                        if (buildings[i][2] > top) {
                            right = buildings[i][0];
                            break;
                        } else if (buildings[i][2] == top) {
                            right = buildings[i][1];
                        }
                    } else if (buildings[i][0] > right) {
                        break;
                    }
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(top);
            lists.add(list);
            left = right;
        }

        if (top > 0) {
            List<Integer> list = new ArrayList<>();
            list.add(right);
            list.add(0);
            lists.add(list);
        }

        return lists;
    }

}
