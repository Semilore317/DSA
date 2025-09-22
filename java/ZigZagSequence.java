package pre_extreme_problems;

import java.util.Scanner;

public class ZigZagSequence {
    //    public int longestZigZagSequence(int[] arr) {
//        // find the longest zigzag sequence and return its length
//
//        // edge cases:
//        if(arr == null || arr.length == 0) return 0;
//
//        // DYNAMIC PROGRAMMING APPROACH - TABULATION
//        int n = arr.length;
//        int[][] dp = new int[n][2];
//        // initialize table with 1;
//
//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 1;
//            dp[i][1] = 1;
//        }
//
//        int len = 1;
//
//        for (int i = 1; i < n; i++) {
//            // check previous indices
//            for (int j = 0; j < i; j++) {
//                if (arr[j] < arr[i]) {
//                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
//                }
//                if (arr[j] > arr[i]) {
//                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
//                }
//            }
//            //len = Math.max(len, dp[i][1]);
//            len = Math.max(len, Math.max(dp[i][0], dp[i][1]));
//        }
//        return len;
//    }
    public int longestZigZagSequence(int[] arr) {
//        // edge cases:
//        if (arr == null || arr.length == 0) return 0;
//
//        int n = arr.length;
//        // These will track the longest zigzag ending at each point with 'up' or 'down' direction.
//        int up = 1, down = 1; // initially, the length of a single element sequence is 1
//        int len = 1;
//
//        for (int i = 1; i < n; i++) {
//            if (arr[i] > arr[i - 1]) {
//                up = down + 1; // If current element is greater, it's an 'up' move
//            } else if (arr[i] < arr[i - 1]) {
//                down = up + 1; // If current element is smaller, it's a 'down' move
//            }
//            len = Math.max(len, Math.max(up, down)); // Track the overall longest length
//        }
//
//        return len;
        int N = arr.length;

        if (N == 0) return 0;

        // each element is at least a zigzag of length 1
        int up = 1, down = 1;
        int maxLength = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;
            } else {
                // equal elements — break the pattern
                up = down = 1;
            }
            maxLength = Math.max(maxLength, Math.max(up, down));
        }

        return maxLength;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int result = new ZigZagSequence().longestZigZagSequence(arr);
        System.out.println(result);
        in.close();
    }
}
