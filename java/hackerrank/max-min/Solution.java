// HackerRank - MaxMin

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static int maxMin(int k, List<Integer> arr) {
        // edge cases
        if (arr == null || arr.size() < k || k ==1 ) return 0;
        // sliding window approach
        Collections.sort(arr);

        // check from index i to index i+k-1 find the unfairness
        // keep sliding that window, and update the unfairness
        int unfairness = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size() - k; i++) {
                // since it's sorted - no need to compute the max and min using other methods
                int max = arr.get(i + k - 1);
                int min = arr.get(i);
                if (max - min < unfairness) {
                    unfairness = max - min;
                }
        }
        return unfairness;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,4,7,2));
        int k = 2;
        System.out.println(maxMin(k,arr));
    }
}
