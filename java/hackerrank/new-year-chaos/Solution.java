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
  public static void minimumBribes(List<Integer> q) {
    // 4,1,2,3 --> 4 bribed 3 people --> stdout "too chaotic"
    // 1,2,3,5,4 --> 5 bribed only 4 --> stdou "1"

    int bribes = 0;
    for (int i = 0; i < q.size(); i++) {
      int person = q.get(i);
      if (person - 1 - i > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Math.max(0, person - 2); j < i; j++) {
        if (q.get(j) > person)
          bribes++;
      }
    }
    System.out.println(bribes);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.minimumBribes(q);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
