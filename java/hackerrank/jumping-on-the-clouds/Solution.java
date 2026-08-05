import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
  public static int jumpingOnClouds(List<Integer> c) {
    int steps = 0;
    int pos = 0;
    int last = c.size() - 1;

    while (pos < last) {
      if (pos + 2 <= last && c.get(pos + 2) == 0)
        pos += 2;
      else
        pos += 1;

      steps++;
    }

    return steps;
  }
}

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(bufferedReader.readLine().trim());
      List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());
      int result = Result.jumpingOnClouds(c);
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
      bufferedReader.close();
      bufferedWriter.close();
    }
}
