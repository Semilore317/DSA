// HackerRank - CountingSort

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> result = new ArrayList<Integer>();
        int[] counting_array = new int[Collections.max(arr) + 1];
        for (int number : arr) {
            counting_array[number]++;
        }

        for (int i = 0; i <= Collections.max(arr); i++) {
            for (int j = 0; j < counting_array[i]; j++) {
                result.add(i);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<Integer> test_array = new ArrayList<>();
        // test case is 19 10 12 10 24 25 22
        test_array.add(19);
        test_array.add(10);
        test_array.add(12);
        test_array.add(10);
        test_array.add(24);
        test_array.add(25);
        test_array.add(22);

        System.out.println(countingSort(test_array));
    }
}
