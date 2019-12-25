package leetcode.problems;

import java.util.*;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 */
@Deprecated
public class LeetCode_0149_Max_Points_on_a_Line {

    public int maxPoints(int[][] points) {
        return run(points);
    }

    public int run(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        int maxCount = 1;
        Map<Fraction, Map<Fraction, Set<Integer>>> lineMap = new HashMap<>();
        Map<Integer, Integer> pointMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                maxCount = Math.max(maxCount,
                        getAndIncrementCount(lineMap, pointMap, points, i, j));
            }
        }

        return maxCount;
    }

    private static int getAndIncrementCount(
            Map<Fraction, Map<Fraction, Set<Integer>>> lineMap,
            Map<Integer, Integer> pointMap,
            int[][] points, int i, int j) {

        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        Fraction slope; //斜率
        Fraction constant; //常数
        Map<Fraction, Set<Integer>> countMap;
        slope = new Fraction(y2 - y1, x2 - x1);
        countMap = lineMap.get(slope);
        if (countMap == null) {
            countMap = new HashMap<>();
            lineMap.put(slope, countMap);
        }

        if (x1 == x2) {
            if (y1 == y2) {
                Integer count = pointMap.get(i);
                if (count == null) {
                    count = 1;
                }
                count ++;
                pointMap.put(i, count);
                return count;
            }
            constant = new Fraction(x1, 1);
        } else {
            if (y1 == y2) {
                constant = new Fraction(y1, 1);
            } else {
                constant = new Fraction(y1 * (x2 - x1) - x1 * (y2 - y1), x2 - x1);
            }
        }

        System.out.println("#### " + slope);
        System.out.println("###### " + constant);
        Set<Integer> indexList = countMap.get(constant);
        if (indexList == null) {
            indexList = new HashSet<>();
            countMap.put(constant, indexList);
        }
        indexList.add(i);
        indexList.add(j);
        return indexList.size();
    }

    public static class Fraction {

        final int mNumerator; //分子
        final int mDenominator; //分母

        public Fraction(int numerator, int denominator) {
            boolean positive = true;
            if (numerator < 0) {
                positive = false;
                numerator = -numerator;
            }
            if (denominator < 0) {
                positive = !positive;
                denominator = -denominator;
            }

            if (denominator != 0) { //分母不为零
                if (numerator >= denominator) { //假分数
                    int reminder = numerator % denominator;
                    if (reminder == 0) {
                        numerator = numerator / denominator;
                        denominator = 1;
                    } else {
                        int divisor = greatestCommonDivisor(numerator, denominator);
                        denominator = denominator / divisor;
                        numerator = numerator / divisor;
                    }
                } else { // 真分数
                    if (numerator == 0) { // 0
                        denominator = 1;
                    } else {
                        int divisor = greatestCommonDivisor(denominator, numerator);
                        denominator = denominator / divisor;
                        numerator = numerator / divisor;
                    }
                }
            } else { //分母为零，表示无穷大
                numerator = 0;
            }

            if (positive) {
                this.mNumerator = numerator;
                this.mDenominator = denominator;
            } else {
                this.mNumerator = -numerator;
                this.mDenominator = denominator;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Fraction) {
                Fraction fraction = (Fraction) obj;
                return this.mDenominator == fraction.mDenominator
                        && this.mNumerator == fraction.mNumerator;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return this.mDenominator + this.mNumerator;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mNumerator);
            sb.append("/");
            sb.append(this.mDenominator);
            return sb.toString();
        }
    }

    public static int greatestCommonDivisor(int x, int y) {
        if (y == 0) {
            return x;
        }
        return greatestCommonDivisor(y, x % y);
    }

}
