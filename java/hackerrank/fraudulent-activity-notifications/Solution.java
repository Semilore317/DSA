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

  static int kthSmallest(int[] count, int k) {
    int cumulative = 0;

    for (int i = 0; i <= 200; i++) {
      cumulative += count[i];
      if (cumulative >= k)
        return i;
    }
    return -1;
  }

  static int twiceMedian(int[] count, int d) {
    if (d % 2 == 1)
      return 2 * kthSmallest(count, d / 2 + 1);

    return kthSmallest(count, d / 2) + kthSmallest(count, d / 2 + 1);
  }

  public static int activityNotifications(List<Integer> expenditure, int d) {
    // 10,20,30,40,50
    // d = 3

    int[] count = new int[201];

    for (int i = 0; i < d; i++)
      count[expenditure.get(i)]++;

    int notifs = 0;
    for (int i = d; i < expenditure.size(); i++) {
      if (expenditure.get(i) >= twiceMedian(count, d))
        notifs++;

      count[expenditure.get(i)]++;
      count[expenditure.get(i - d)]--;
    }

    return notifs;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.activityNotifications(expenditure, d);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
