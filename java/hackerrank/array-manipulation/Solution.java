// HackerRank - ArrayManipulation

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
            * Complete the 'arrayManipulation' function below.
            *
            * The function is expected to return a LONG_INTEGER.
            * The function accepts following parameters:
            *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
//    public static List<List<Integer>> create2DList(int rows, int cols) {
//        // Initialize the result 2D list
//        List<List<Integer>> result = new ArrayList<>();
//
//        // Create 'rows' number of rows
//        for (int i = 0; i < rows; i++) {
//            // Create a new row with 'cols' elements, initialized to 0
//            List<Integer> row = new ArrayList<>();
//            for (int j = 0; j < cols; j++) {
//                row.add(0); // Default value of 0, can be changed
//            }
//            result.add(row);
//        }
//
//        return result;
//    }
//    public static int maxValue(List<List<Integer>> list) {
//        return Collections.max(list.get(list.size() - 1));
//    }
//    public static long arrayManipulation(int n, List<List<Integer>> queries) {
//        // create a new List with rows n and coluumns
//        List<List<Integer>> result = create2DList(n, queries.size());
//
//        // add every last value in the rows to the indexes a to b
//        // assign the value to the result zeroes
//        // return the largest value in the last row of the result array
//        //for (List<Integer> row : queries) {
//        for (int i = 0; i < queries.size(); i++) {
//            List<Integer> row = queries.get(i);
//            int a = row.get(0);
//            int b = row.get(1);
//            int k = row.get(2);
//
//            for (int j = a-1; j <=b-1; j++) {
//                if (j >= 0 && j < row.size()) { // Ensure index is within bounds
//                    int currentValue = row.get(i);
//                    row.set(i, currentValue + k);
//                } else {
//                    System.out.println("Warning: Index " + i + " is out of bounds for the list.");
//                }
//            }
//        }
//        return (long) maxValue(result);
//    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // use a 1D array to store the difference array
        long[] arr = new long[n + 1]; // +1 to handle end index updates

        // process each query
        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            // update the difference array
            arr[a - 1] += k; // add k at the start index (0-based)
            if (b < n) {
                arr[b] -= k; // subtract k at the end index + 1 (0-based)
            }
        }

        // subtract k at the last index (0-based_)
        // compute the maximum value by calculating the prefix sum
        long max = 0;
        long current = 0;
        for (int i = 0; i < n; i++) {
            current += arr[i]; // running sum represents the value at index i
            max = Math.max(max, current); // update max if current is larger
        }

        return max;
    }

    public static void main(String[] args) {
        int n = 10;
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> row_1 = new ArrayList<>();
        row_1.add(1);
        row_1.add(5);
        row_1.add(3);
        queries.add(row_1);
        List<Integer> row_2 = new ArrayList<>();
        row_2.add(4);
        row_2.add(8);
        row_2.add(7);
        queries.add(row_2);
        List<Integer> row_3 = new ArrayList<>();
        row_3.add(6);
        row_3.add(9);
        row_3.add(1);
        queries.add(row_3);

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
