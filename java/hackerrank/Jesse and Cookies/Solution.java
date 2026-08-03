import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
  public static int cookies(int k, List<Integer> A) {
    // while sweetness < k
    // sweetness = (1 * least) + (2 * 2nd least)
    int iterations = 0;
    while (A.get(0) < k) {
      if (A.size() == 1 && A.get(0) < k) {
        System.out.println(-1);
        return -1;
      }

      Collections.sort(A);
      int x = A.get(0);
      int y = A.get(1);

      A.remove(x);
      A.remove(y);

      A.add(x + (2 * y));
      iterations++;
    }

    System.out.println(iterations);
    return iterations;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int k = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.cookies(k, A);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
