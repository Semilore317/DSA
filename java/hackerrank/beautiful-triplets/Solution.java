// HackerRank - BeautifulTriplets

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int maxValue(List<Integer> arr){
        int max = 0;
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }
    public static int beautifulTriplets(int d, List<Integer> arr){
        //edge cases
        if (arr.size() < 3) return 0;

        // implement a frequency array
        int[] frequency_arr = new int[20001];

        for (Integer i : arr) {
            frequency_arr[i]++;
        }
        //i , i + d, i  + 2d
        // for each value i, check if value i+x and i+2x exist, if so, increment the count
        int count = 0;
        for (int i = 0; i <= maxValue(arr) ; i++) {
            // check if all three values exist in the List
            if (    i + d + d < frequency_arr.length &&
                    frequency_arr[i] > 0 &&
                    frequency_arr[i+d] > 0 &&
                    frequency_arr[i+d+d] > 0) {
                // add all the permutations of the three "triplets"
                count += frequency_arr[i] * frequency_arr[i + d] * frequency_arr[i + d + d];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Integer[] array = {1, 2, 4, 5, 7, 8, 10};
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(array));
        System.out.println(beautifulTriplets(3, arr));
    }
}