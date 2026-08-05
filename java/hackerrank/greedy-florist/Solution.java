// HackerRank - GreedyFlorist

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int getMinimumCost(int k, int[] c) {
        int totalCost = 0;

        Integer[] prices = new Integer[c.length];
        for (int i = 0; i < c.length; i++) {
            prices[i] = c[i];
        }

        // buy the most expensive flowers first, then multipliers are used on the highest costs
        Arrays.sort(prices, Collections.reverseOrder());

        for (int i = 0; i < prices.length; i++) {
        // (i/k) - number of times each friend has bought the flower
            totalCost += ((i/k) + 1) * prices[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] c = {1,2,3,4}; //c.length() =4, number of purchased flowers = 4
        int  k = 3; // number of people buying flowers
        System.out.println(getMinimumCost(k, c));
    }
}
