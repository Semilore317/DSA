// LeetCode #121 - Best Time to Buy and Sell Stock

import java.util.Arrays;

import static java.util.Collections.max;

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int[] rightSlice = Arrays.copyOfRange(prices, i, n);

            for (int j = i; j < n; j++) {
                if (rightSlice[j] > max) {
                    max = rightSlice[j];
                }
            }
        }

        maxProfit = max;

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        problem_121 obj = new problem_121();
        System.out.println(obj.maxProfit(prices));
    }
}
