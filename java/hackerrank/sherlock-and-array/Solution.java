// HackerRank - SherlockAndArray


import java.io.*;
import java.util.*;

class SherlockAndArrayResult {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        // sherlock and array
        int totalsum = 0;
        for (int num : arr) {
            totalsum += num;
        }

        int leftsum = 0;
        for (int i =0; i < arr.size(); i++){
            int rightsum = totalsum - leftsum - arr.get(i);
            if (leftsum == rightsum){
                return "YES";
            }
        }

        return "NO";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int T = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, T).forEach(TItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                String result = SherlockAndArrayResult.balancedSums(arr);
//
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        SherlockAndArrayResult result = new SherlockAndArrayResult();
        result.balancedSums(arr);
    }
}

