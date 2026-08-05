// HackerRank - PickingNumbers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int pickingNumbers(List<Integer> a) {
        int[] frequency_arr = new int[101]; // as per the problem constraints

        // fill in the values in the frequency_arr array
        for (int number : a) {
            frequency_arr[number]++;
        }
        // {0,0,1,2,2,3,3,3}
        // {2,1,2,3}
        int maxLength = 0;

        // iterate through frequency_arr to find the maximum length subarray
        // by considering pairs of adjacent numbers (i and i+1).
        for (int i = 0; i < frequency_arr.length - 1; i++) {
            // the sum of frequencies of i and i+1 is a possible subarray
            // the max difference between two values <= 1
            int currentLength = frequency_arr[i] + frequency_arr[i + 1];
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        Integer[] a = {1,1,2,2,4,4,5,5,5};
        arr.addAll(Arrays.asList(a));
        System.out.println(pickingNumbers(arr));
    }
}
