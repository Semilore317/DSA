import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  static int expectedSeq;
  static int maxBuffer;

  static Map<Integer, String> buffer = new HashMap<>();

  public static void Replayer(int start_seq, int max_buffer) {
    expectedSeq = start_seq;
    maxBuffer = max_buffer;
    buffer.clear();
  }

  public static void push(int seq, String payload) {
    // already replayed OR duplicate bufered
    if (seq < expectedSeq || buffer.containsKey(seq)) {
      System.out.println("null");
      return;
    }

    // out-of-order event
    if (seq > expectedSeq && buffer.size() == maxBuffer) {
      System.out.println("error");
      return;
    }

    buffer.put(seq, payload);

    List<String> replayed = new ArrayList<>();

    while (buffer.containsKey(expectedSeq)) {
      replayed.add(buffer.remove(expectedSeq));
      expectedSeq++;
    }

    if (replayed.isEmpty()) {
      System.out.println("null");
    } else {
      System.out.println(String.join(" ", replayed));
    }

  }

  public static String getStringArg(String input, int index) {
    return input.split("\s")[index];
  }

  public static int getIntArg(String input, int index) {
    return Integer.parseInt(input.split("\\s+")[index]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String init = sc.nextLine();

    Replayer(
        getIntArg(init, 1),
        getIntArg(init, 2));

    while (sc.hasNext()) {
      String line = sc.nextLine();

      push(
          getIntArg(line, 1),
          getStringArg(line, 2));
    }

    sc.close();
  }
}
