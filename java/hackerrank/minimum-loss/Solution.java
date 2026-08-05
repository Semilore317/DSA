// HackerRank - MinimumLoss

import java.util.*;

public class Solution {
    public static int minimumLoss(List<Long> price) {
        TreeSet<Long> sortedPrices = new TreeSet<>();
        long minimumLoss = Long.MAX_VALUE;

        for (long p : price) {
            // find the smallest price greater than the current price - built-in treeset method
            Long higherPrice = sortedPrices.higher(p);
            if (higherPrice != null) {
                // if a higher price exists, calculate potential loss
                minimumLoss = Math.min(minimumLoss, higherPrice - p);
            }
            // add the current price to the sorted set
            sortedPrices.add(p);
        }
        return (int) minimumLoss;
   }

    public static void main(String[] args) {
        List<Long> price = new ArrayList<>();
        price.add(20L);
        price.add(15L);
        price.add(8L);
        price.add(2L);
        price.add(12L);

        //{5,3,8,2,10}

        System.out.println(minimumLoss(price));
    }

}

