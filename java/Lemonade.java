package pre_extreme_problems;

import java.util.*;
import java.io.*;

public class Lemonade {
    private static boolean solvable(int targetDifference, int[] minCapacityPerBottle,
                                    int[] maxCapacityPerBottle, long totalLemonade, int numberOfBottles) {

        // find the valid range for the minimum value M
        // M must satisfy: for all i, max(M, minCapacityPerBottle[i]) <= min(M + targetDifference, maxCapacityPerBottle[i])
        // which simplifies to: M <= maxCapacityPerBottle[i] and M >= minCapacityPerBottle[i] - targetDifference

        long minPossibleM = 0;
        long maxPossibleM = Integer.MAX_VALUE / 2;

        for (int bottleIndex = 0; bottleIndex < numberOfBottles; bottleIndex++) {
            // M cannot exceed any bottle's maximum capacity
            maxPossibleM = Math.min(maxPossibleM, maxCapacityPerBottle[bottleIndex]);

            // M cannot be so low that M + targetDifference < minCapacityPerBottle[i]
            minPossibleM = Math.max(minPossibleM, (long)minCapacityPerBottle[bottleIndex] - targetDifference);
        }

        minPossibleM = Math.max(0, minPossibleM);

        if (minPossibleM > maxPossibleM) {
            return false;
        }

        // now calculate the total volume range for the best M
        // we need to find if there's any M in [minPossibleM, maxPossibleM] where the total fits

        // calculate the minimum possible total across this range
        // this is achieved by taking the minimum of the endpoint totals

        long minTotalAtLowM = 0;
        long minTotalAtHighM = 0;

        // check low M
        {
            boolean feasible = true;
            for (int bottleIndex = 0; bottleIndex < numberOfBottles; bottleIndex++) {
                long low = Math.max(minPossibleM, minCapacityPerBottle[bottleIndex]);
                long high = Math.min(minPossibleM + targetDifference, maxCapacityPerBottle[bottleIndex]);

                if (low > high) {
                    feasible = false;
                    break;
                }
                minTotalAtLowM += low;
            }

            if (!feasible) {
                minTotalAtLowM = Long.MAX_VALUE;
            }
        }

        // check high M
        {
            boolean feasible = true;
            for (int bottleIndex = 0; bottleIndex < numberOfBottles; bottleIndex++) {
                long low = Math.max(maxPossibleM, minCapacityPerBottle[bottleIndex]);
                long high = Math.min(maxPossibleM + targetDifference, maxCapacityPerBottle[bottleIndex]);

                if (low > high) {
                    feasible = false;
                    break;
                }
                minTotalAtHighM += low;
            }

            if (!feasible) {
                minTotalAtHighM = Long.MAX_VALUE;
            }
        }

        long bestMinTotal = Math.min(minTotalAtLowM, minTotalAtHighM);

        if (bestMinTotal == Long.MAX_VALUE) {
            return false;
        }

        // maximum total is best minimum plus the maximum we can add
        long bestMaxTotal = bestMinTotal + (long)targetDifference * numberOfBottles;

        // check if totalLemonade fits in this range
        return bestMinTotal <= totalLemonade && totalLemonade <= bestMaxTotal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        int[] a = new int[N];
        int[] b = new int[N];
        int maxB = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            maxB = Math.max(maxB, b[i]);
        }

        // binary search on the min difference
        int left = 0;
        int right = maxB;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (solvable(mid, a, b, L, N)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}