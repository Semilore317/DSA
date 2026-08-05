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
    // remove the two least-sweet cookies,
    // combine them into a single cookie
    // return the number of iterations required to get the optimal setup
    // if not possible return -1

    PriorityQueue<Integer> queue = new PriorityQueue<>(A); // guarantees the poll is the min
    int iterations = 0;
    while (queue.peek() < k) {
      if (queue.size() < 2)
        return -1;

      int least = queue.poll();
      int secondLeast = queue.poll();
      queue.add(least + (2 * secondLeast));
      iterations++;
    }

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
