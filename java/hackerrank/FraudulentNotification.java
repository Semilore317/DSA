// HackerRank - FraudulentNotification

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudulentNotification {
    public static double median(int[] freq, int d) {
        // find the median of the last d elements using the frequency array
        int count = 0;
        //{1,2,3,3,4,5}
        //{0,1,1,2,1,1.....,0}
        int mid = d / 2; // d is 200 from the constraints in the problem
        double median;

        if (d % 2 == 1) {
            // odd number of elements: find the (d/2 + 1)th element
            for (int i = 0; i < freq.length; i++) {
                count += freq[i];
                if (count > mid) {
                    return i; // Middle element
                }
            }
        } else {
            // even number of elements: average of (d/2)th and (d/2 + 1)th elements
            int firstMid = -1;
            for (int i = 0; i < freq.length; i++) {
                count += freq[i];
                if (firstMid == -1 && count >= mid) {
                    firstMid = i;
                }
                if (count > mid) {
                    return (firstMid + i) / 2.0; // average of two middle elements
                }
            }
        }
        // shouldn't reach here with suitable inputs
        throw new IllegalStateException("Cannot compute median");
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // input validation
        if (expenditure == null || expenditure.size() < d || d <= 0) {
            throw new IllegalArgumentException("Invalid input: list must be non-null, d must be positive, and list size must be at least d");
        }

        int notifs = 0;
        int maxValue = 200; // constraint: expenditures are between 0 and 200
        int[] freq = new int[maxValue + 1]; // frequency array for values 0 to 200

        // initialize frequency array for the first d elements
        for (int i = 0; i < d; i++) {
            freq[expenditure.get(i)]++;
        }

        // process sliding window
        for (int i = d; i < expenditure.size(); i++) {
            // compute median and limit
            double median = median(freq, d);
            int limit = (int) (2 * median); // use int for precision in comparison

            if (expenditure.get(i) >= limit) {
                notifs++;
            }

            // update frequency array for sliding window
            freq[expenditure.get(i - d)]--; // remove oldest element
            freq[expenditure.get(i)]++;     //add newest element
        }

        return notifs;
    }
    public static void main(String[] args) {
        List<Integer> expenditure = new ArrayList<Integer>();
        // 2 3 4 2 3 6 8 4 5
        Integer[] arr = {2,3,4,2,3,6,8,4,5};
        //Integer[] arr = {9,5};
        Collections.addAll(expenditure, arr);

        int d = 5;
        System.out.println(activityNotifications(expenditure, d));
    }
}
