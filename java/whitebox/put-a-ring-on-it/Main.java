import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  private static int maxCapacity;
  private static Queue<String> ringBuffer;

  public static void RingBuffer(int capacity) {
    maxCapacity = capacity;
    ringBuffer = new ArrayDeque<>(maxCapacity);
  }

  public static void push(String event) {
    // enqueue the event
    // if buffer is full... dequeue oldest event before inserting the new one
    if (ringBuffer.size() == maxCapacity) {
      ringBuffer.poll();
      ringBuffer.add(event);
    } else {
      ringBuffer.add(event);
    }
  }

  public static void snapshot() {
    // iterate through the queue from oldest to newest and print all the items in
    // order (might be an optimization along the way, i'll figure it out)
    // if queue is empty, System.out.println("")
    if (ringBuffer.isEmpty()) {
      System.out.println("");
    } else {
      for (String item : ringBuffer) {
        System.out.print(item + " ");
      }
      System.out.println("");
    }
  }

  // method for regex matching
  // optionalInt contains either a primitive int or nothing... much better than
  // using Optional<Integer> since it boxes into an object
  public static OptionalInt extractNumber(String input, String expectedText) {
    String regex = "^" + Pattern.quote(expectedText) + "\\s(\\d+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    if (matcher.matches()) {
      return OptionalInt.of(Integer.parseInt(matcher.group(1)));
    }

    return OptionalInt.empty(); // Returns empty if validation fails
  }

  public static String extractEvent(String input) {
    String regex = "^" + Pattern.quote("push") + "\\s(.+)$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) {
      return matcher.group(1);
    }

    return ""; // fallback... hopefully shouldn't reach here
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // initialization of the RingBuffer
    String firstLine = sc.nextLine();
    OptionalInt extractedCapacity = extractNumber(firstLine, "RingBuffer");
    int capacity = extractedCapacity.orElseThrow(() -> new IllegalArgumentException("Invalid initialization command"));
    RingBuffer(capacity);

    while (sc.hasNextLine()) {
      // check what kind of commands are there;
      // push or snapshot
      String currentLine = sc.nextLine();
      if (currentLine.contains("push")) {
        push(extractEvent(currentLine));
        System.out.println("null");
      } else if (currentLine.contains("snapshot")) {
        snapshot();
      }
    }

    sc.close();
  }
}
