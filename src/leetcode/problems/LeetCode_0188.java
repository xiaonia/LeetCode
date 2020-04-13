package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * 188. Best Time to Buy and Sell Stock IV
 *
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class LeetCode_0188 {

    public int maxProfit(int k, int[] prices) {
        return run(k, prices);
    }

    public static int run(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length < 2) {
            return 0;
        }

        List<Integer> points = new ArrayList<>();
        int transactions = 0;
        boolean increase = false;
        int start = 0;
        int max = 0;
        int min = 0;
        int profit = 0;
        for (int i = start + 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) { // 谷 .../
                min = prices[start];
                points.add(min);
                start = i;
                increase = true;
                break;
            }
            if (prices[i - 1] > prices[i]) { // 峰 '''\
                //max = prices[start];
                //points.add(max);
                start = i;
                increase = false;
                break;
            }
        }

        for (int j = start + 1; j < prices.length; j++) {
            if (increase) {
                if (prices[j - 1] > prices[j]) { // 峰 /'''\
                    max = prices[start];
                    points.add(max);
                    transactions ++;
                    profit = profit + (max - min);
                    increase = false;
                }
                start = j;
            } else {
                if (prices[j - 1] < prices[j]) { // 谷 \.../
                    min = prices[start];
                    points.add(min);
                    increase = true;
                }
                start = j;
            }
        }

        if (increase) { // 峰 /'''
            max = prices[prices.length - 1];
            points.add(max);
            transactions ++;
            profit = profit + (max - min);
        } else { // 谷 \...
            //min = prices[prices.length - 1];
        }

        if (points.size() < 2) {
            return profit;
        }

        if (k >= transactions) {
            return profit;
        }

        int[][] temp = new int[transactions][transactions];

        //
        for (int i = 0; i < k; i++) {
          for (int j = i; j < transactions; j++) {

          }
        }

        while (k < transactions) {
            int v = 0;
            int p = 1;
            int val = points.get(1) - points.get(0);
            profit = profit - val;

            int cur = 0;
            int pre = points.get(0);
            int next = 0;
            for (int i = 1; i < points.size(); i+=2) {
                cur = points.get(i);
                if (cur - pre < val) {
                    profit = profit + val;
                    val = cur - pre;
                    p = i;
                    v = i - 1;
                    profit = profit - val;
                }

                if (i + 1 < points.size()) {
                    next = points.get(i + 1);
                    if (cur - next < val) {
                        profit = profit + val;
                        val = cur - next;
                        p = i;
                        v = i + 1;
                        profit = profit - val;
                    }
                }

                pre = next;
            }
            points.remove(p);
            points.remove(v);
            transactions --;
        }

        return profit;
    }

}
