import java.util.*;

public class Main {

  static int windowSeconds;
  static int queueCapacity;
  static int lastTimestamp;

  static ArrayDeque<Integer> q = new ArrayDeque<>();

  public static void rateLimiter(int seconds, int capacity) {
    // initializes the system with defined params
    // int seconds --> length of window
    // int capacity --> max events that can exist at any instant
    windowSeconds = seconds;
    queueCapacity = capacity;
  }

  static void expire(int timestamp) {
    while (!q.isEmpty() && q.peekFirst() <= timestamp) {
      q.pollFirst();
    }
    lastTimestamp = timestamp;
  }

  public static void add(int count, int timestamp) {
    // add count number of events at timestamp
    // if the number of events exceeds the remaining capacity
    // add as many that will fill up the remaining space
    // discard the rest
    lastTimestamp = timestamp;
    expire(lastTimestamp);

    int addable = Math.min(count, queueCapacity - q.size());
    for (int i = 0; i < addable; i++) {
      q.add(timestamp + windowSeconds);
    }
  }

  public static int check() {
    // return the number of events in the active time window
    expire(lastTimestamp);
    return q.size();
  }

  public static String[] tokenize(String input) {
    String[] tokenArr = input.split("\s");
    return tokenArr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in).useDelimiter("\s");

    String initializr = sc.nextLine();
    System.out.println("null");
    String[] initArr = tokenize(initializr);
    rateLimiter(Integer.parseInt(initArr[1]), Integer.parseInt(initArr[2]));

    while (sc.hasNextLine()) {
      String[] inputArr = tokenize(sc.nextLine());

      if (inputArr[0].equals("add")) {
        add(Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2]));
        System.out.println("null");
      } else if (inputArr[0].equals("check")) {
        System.out.println(check());
      }
    }

    sc.close();
  }
}
