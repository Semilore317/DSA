
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Result {
  public static int sockMerchant(int n, List<Integer> ar) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int x : ar) {
      int count = Collections.frequency(ar, x);
      countMap.put(x, count);
    }

    int totalPairs = 0;
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      Integer count = entry.getValue();

      totalPairs += count / 2;
    }

    return totalPairs;
  }
}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
