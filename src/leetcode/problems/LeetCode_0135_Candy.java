package leetcode.problems;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Example 1:
 *
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 *              The third child gets 1 candy because it satisfies the above two conditions.
 */
@Deprecated
public class LeetCode_0135_Candy {

    public int candy(int[] ratings) {
        return run(ratings);
    }

    public int run(int[] ratings) {
        int sum = 0;
        int current = 0;
        int count = 0; //连续递减计数

        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                current = 1;
                count = 1;
            } else {
                if (ratings[i] > ratings[i -1]) { //递增
                    if (count > 1) { //第一个递增节点
                        if (current > 1) { // 多退
                            sum += ((count - 1) * (1 - current));
                        } else if (current < 1) { //少补
                            sum += (count * (1 - current));
                        }
                        current = 1;
                        count = 1;
                    }
                    current ++;

                } else if (ratings[i] < ratings[i -1]) { //递减
                    current --;
                    count ++;
                    if (i == ratings.length - 1) {
                        if (count > 1) {
                            if (current > 1) {
                                sum += ((count - 1) * (1 - current));
                            } else if (current < 1) {
                                sum += (count * (1 - current));
                            }
                            //count = 1;
                        }
                    }
                }
                else { //相等
                    if (count > 1) {
                        if (current > 1) {
                            sum += ((count - 1) * (1 - current));
                        } else if (current < 1) {
                            sum += (count * (1 - current));
                        }
                        count = 1;
                    }
                    current = 1;
                }
            }

            sum += current;
        }

        return sum;
    }

}
