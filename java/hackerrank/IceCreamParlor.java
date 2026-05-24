// HackerRank - IceCreamParlor

import java.io.*;
import java.text.spi.BreakIteratorProvider;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        /* NAIVE APPROACH */
//        // use a two pointer approach
//        // for each value i, check if there's another value j that'll be added to it to get m, if there is, return i and j in an integer list
//        List<Integer> result = new ArrayList<>();
//        for (Integer i : arr) {
//            for (Integer j : arr) {
//                if (i + j == m && arr.get(i) != arr.get(j)) {
//                    result.add(arr.get(i) + 1);
//                    result.add(arr.get(j) + 1);
//                    break;
//                }else{
//                    continue;
//                }
//            }
//        }
//        return result;

        // hashmap to store cost to index mappings
        Map<Integer, Integer> costToIndex = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // iterate through the array
        for (int i = 0; i < arr.size(); i++) {
            int cost = arr.get(i);
            int complement = m - cost;

            // Check if complement exists in the map
            if (costToIndex.containsKey(complement)) {
                // Add 1-based indices to result
                result.add(costToIndex.get(complement) + 1); // First index
                result.add(i + 1);                          // Second index
                break;
            }

            // Store current cost and its index
            costToIndex.put(cost, i);
        }

        return result;
    }

}

public class IceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("iceCreamParlor.txt")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());


        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
