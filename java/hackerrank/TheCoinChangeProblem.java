// HackerRank - TheCoinChangeProblem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class TheCoinChangeProblemResult {
    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
    public static long getWays(int n, List<Long> c) {
        // Initialize arr array for amounts from 0 to n
        long[] arr = new long[n + 1];
        arr[0] = 1; // Base case: one way to make amount 0 (no coins)

        // Process each coin denomination
        for (long coin : c) {
            // Update arr for each amount from coin to n
            for (int amount = (int) Math.min(coin, n); amount <= n; amount++) {
                if (coin <= amount) {
                    arr[amount] += arr[amount - (int) coin];
                }
            }
        }

        return arr[n];
    }
}

public class TheCoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = TheCoinChangeProblemResult.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
