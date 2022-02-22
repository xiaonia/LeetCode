package leetcode.problems;

import leetcode.utils.DebugUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 * 210. Course Schedule II
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class LeetCode_0210 {

    public static void main(String[] args) {
        DebugUtils.print(
                new LeetCode_0210().findOrder(
                        4,
                        new int[][]{
                                {1,0},
                                {2,0},
                                {3,1},
                                {3,2}
                        }
                )
        );
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topSort(numCourses, prerequisites);
    }

    private static int[] topSort(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        List<List<Integer>> nextList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextList.add(new ArrayList<>());
            countList.add(0);
        }

        for (int[] prerequisite : prerequisites) {
            nextList.get(prerequisite[1]).add(prerequisite[0]);
            countList.set(prerequisite[0], countList.get(prerequisite[0]) + 1);
        }

        int index = 0;
        for (int j = 0; j < countList.size(); j++) {
            if (countList.get(j) == 0) {
                courses[index++] = j;
            }
        }

        for (int i = 0; i < index; i++) {
            for (int next : nextList.get(courses[i])) {
                int count = countList.get(next) - 1;
                if (count == 0) {
                    courses[index++] = next;
                } else {
                    countList.set(next, count);
                }
            }
        }

        if (index < numCourses) {
            return new int[0];
        }
        return courses;
    }

}
