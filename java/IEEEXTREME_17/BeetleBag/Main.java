package IEEEXTREME_17.BeetleBag;// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    private static int getMaxFightingPower(int capacity, int[] weights, int[] powers, int n) {
        // TODO: Implement the logic (likely dynamic programming - knapsack problem)
        int[] dp = new int[capacity + 1];

        // loop through each gadget
        for (int i = 0; i < n; i++){
            int weight = weights[i];
            int power = powers[i];

            // we iterate backwards to avoid using the same item more than once
            for (int w = capacity; w >= weight; w--){
                // compare: not taking it vs taking it (0/1)
                dp[w] = Math.max(dp[w], dp[w-weight] + power);
            }
        }


        // contains the max power for the full capacity
        return dp[capacity];
    }
	public static void main (String[] args) throws java.lang.Exception {
        // the first line of input -> nunmber of test cases (1<=t<=25)
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int capacity = scanner.nextInt(); // bag capacity
            int n = scanner.nextInt();        // number of gadgets

            int[] weights = new int[n];
            int[] powers = new int[n];

            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
                powers[i] = scanner.nextInt();
            }

            int maxFightingPower = getMaxFightingPower(capacity, weights, powers, n);

            System.out.println(maxFightingPower);
        }

        scanner.close();
    }
}