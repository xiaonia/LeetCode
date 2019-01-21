package leetcode.problems;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
//TODO
public class LeetCode_0121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        return run(prices);
    }

    public static int run(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                maxPrice = minPrice = prices[i];
            } else if (prices[i] > maxPrice) {
                if (prices[i] - minPrice > maxProfit) {
                    maxPrice = prices[i];
                    maxProfit = maxPrice - minPrice;
                }
            }
        }
        return maxProfit;

        /*int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;*/
    }

    //最大利润必然跟最高点或者最低点相关
    public static int call(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}
