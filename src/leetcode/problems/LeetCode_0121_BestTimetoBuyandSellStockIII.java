package leetcode.problems;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
@Deprecated
public class LeetCode_0121_BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        return run(prices);
    }

    public static int run(int[] prices) {
        int[] tmp = new int[prices.length + 1];
        int maxProfit = 0;
        int leftProfit = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightProfit = 0;
        int rightMax = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leftMin) {
                leftMin = prices[i];
            } else {
                if (prices[i] - leftMin > leftProfit) {
                    leftProfit = prices[i] - leftMin;
                }
            }
            tmp[i + 1] = leftProfit;
        }


        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > rightMax) {
                rightMax = prices[i];
            } else {
                if (rightMax - prices[i] > rightProfit) {
                    rightProfit = rightMax - prices[i];
                }
            }
            maxProfit = Math.max(maxProfit, rightProfit + tmp[i]);
        }

        return maxProfit;
    }

    /*public static int run(int[] prices) {
        int maxProfit = 0;
        int firstProfit = 0;
        int secondProfit = 0;
        Integer[] tmp = new Integer[prices.length];

        for (int i = 1; i < prices.length; i++) {
            firstProfit = call(prices, 0, i, tmp);
            secondProfit = call(prices, i + 1, prices.length - 1, tmp);
            maxProfit = Math.max(maxProfit, firstProfit + secondProfit);
        }

        return maxProfit;
    }

    public static int call(int[] prices, int start, int end, Integer[] tmp) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        if (start >= end) {
            return profit;
        }

        for (int i = start; i <= end; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > profit) {
                    profit = prices[i] - minPrice;
                }
            }
        }
        return profit;
    }
*/
}
