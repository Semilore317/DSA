// HackerRank - TwoDArrayDS

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArrayDS {
    public static int hourglassSum(List<List<Integer>> arr) {
        // initialize maxSum to the smallest possible value
        int maxSum = Integer.MIN_VALUE;

        // iterate over possible hourglass starting points (i, j)
        // since hourglass is 3x3, i and j go from 0 to 3 (6-2)
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                // calculate sum of current hourglass
                int currentSum = arr.get(i).get(j) // a
                        + arr.get(i).get(j+1)   // b
                        + arr.get(i).get(j+2)   // c
                        + arr.get(i+1).get(j+1) // d
                        + arr.get(i+2).get(j)   // e
                        + arr.get(i+2).get(j+1) // f
                        + arr.get(i+2).get(j+2); // g

                // Update maxSum if currentSum is larger
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {List<List<Integer>> twoD_arr = new ArrayList<List<Integer>>();
        //1 1 1 0 0 0
        //0 1 0 0 0 0
        //1 1 1 0 0 0
        //0 0 2 4 4 0
        //0 0 0 2 0 0
        //0 0 1 2 4 0

        /* HOURGLASS VALUES*/
        //a b c
        //  d
        //e f g

        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1,1,1,0,0,0),
                Arrays.asList(0,1,0,0,0,0),
                Arrays.asList(1,1,1,0,0,0),
                Arrays.asList(0,0,2,4,4,0),
                Arrays.asList(0,0,0,2,0,0),
                Arrays.asList(0,0,1,2,3,0)
        );


    }
}
