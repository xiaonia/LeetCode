package leetcode.problems;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 *
 * Note:
 *
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 *
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * Output: 3
 *
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 *
 * Input:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * Output: -1
 *
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 */

@Deprecated
public class LeetCode_0134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        return run(gas, cost);
    }

    //O(n)
    public int run(int[] gas, int[] cost) {
        int length = gas.length;
        int[][] infos = new int[length][2];
        for (int j = 0; j < length; j++) {
            infos[j][0] = -1;
            infos[j][1] = -1;
        }

        int count = 0;
        int start = length - 1;
        int end = -1;
        while (true) {
            if (count >= length) {
                break;
            }

            end = buildCacheInfo(gas, cost, start, infos);
            if (end < 0) {
                return -1;
            }

            if (end <= start) {
                count += (start - end + 1);
            } else {
                count += ((start - 0 + 1) + (length - 1 - end + 1));
            }

            if (end == 0) {
                start = length - 1;
            } else {
                start = end - 1;
            }
        }

        for (int j = 0; j < length; j++) {
            if (infos[j][0] < 0) {
                return j;
            }
        }

        return -1;
    }

    private int buildCacheInfo(int[] gas, int[] cost, int index, int[][] infos) {
        int length = gas.length;
        int i = index;
        int count = 0; //traversal count

        int remainder = gas[i] - cost[i];
        if (remainder >= 0) {
            return i;
        }
        count ++;

        while (true) {
            if (count >= length) {
                return -1;
            }

            if (i == 0) {
                i = length - 1;
            } else {
                i--;
            }

            if (infos[i][1] >= 0) { //use cache
                remainder += infos[i][1];
                if (i > infos[i][0]) {
                    count += (i - infos[i][0] + 1);
                } else {
                    count += ((i - 0 + 1) + (length - 1 - infos[i][0] + 1));
                }
                if (count > length) {
                    return -1;
                }
                i = infos[i][0];
            } else {
                remainder += (gas[i] - cost[i]);
                count ++;
            }

            if (remainder >= 0) {
                infos[index][0] = i;
                infos[index][1] = remainder;
                return i;
            } else {
                infos[i][0] = index;
                infos[i][1] = remainder;
            }
        }
    }

}
