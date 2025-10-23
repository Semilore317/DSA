package IEEEXTREME_17.DogWalking;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static long dogWalkingMinSum(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return 0L;
        if (k >= n) return 0L; // each dog can be alone -> all ranges 0

        Arrays.sort(arr);

        // compute adjacent gaps: gaps[i] = arr[i+1] - arr[i]
        // there are (n-1)  gaps.
        int[] gaps = new int[Math.max(0, n - 1)];
        for (int i = 0; i < n - 1; i++) gaps[i] = arr[i + 1] - arr[i];

        // sort gaps ascending order to remove the largest gaps
        Arrays.sort(gaps);

        // total range of the whole array:
        long totalRange = (long) arr[n - 1] - arr[0];

        // sum the largest (k-1) gaps to remove them.
        long remove = 0L;
        // start from end of sorted gaps (largest values)
        for (int i = gaps.length - 1, cnt = 0; i >= 0 && cnt < k - 1; i--, cnt++) {
            remove += gaps[i];
        }

        // final minimal sum of ranges = totalRange - sum_of_removed_gaps
        return totalRange - remove;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // -> dogs
            int k = scanner.nextInt(); // -> employee walkers
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

            System.out.println(dogWalkingMinSum(a, k));
        }
        scanner.close();
    }

}
