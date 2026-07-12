import java.util.*;

public class Main {

  static long windowSeconds;
  static long queueCapacity;
  static long lastTimestamp;

  static class Batch {
    long expiry;
    long count;

    Batch(Long expiry, long count) {
      this.expiry = expiry;
      this.count = count;
    }
  }

  static ArrayDeque<Batch> q = new ArrayDeque<>();
  static long currentSize;

  public static void rateLimiter(long seconds, long capacity) {
    // initializes the system with defined params
    // long seconds --> length of window
    // long capacity --> max events that can exist at any instant
    windowSeconds = seconds;
    queueCapacity = capacity;
  }

  static void expire(long timestamp) {
    while (!q.isEmpty() && q.peekFirst().expiry <= timestamp) {
      currentSize -= q.peekFirst().count;
      q.pollFirst();
    }
    lastTimestamp = timestamp;
  }

  public static void add(long count, long timestamp) {
    // add count number of events at timestamp
    // if the number of events exceeds the remaining capacity
    // add as many that will fill up the remaining space
    // discard the rest
    lastTimestamp = timestamp;
    expire(lastTimestamp);

    long addable = Math.min(count, queueCapacity - currentSize);

    // too expensive for high number of inserts
    /*
     * for (long i = 0L; i < addable; i++) {
     * q.add(timestamp + windowSeconds);
     * }
     */
    if (addable > 0) {
      q.addLast(new Batch(timestamp + windowSeconds, addable));
      currentSize += addable;
    }
  }

  public static long check() {
    // return the number of events in the active time window
    expire(lastTimestamp);
    return currentSize;
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
    rateLimiter(Long.parseLong(initArr[1]), Long.parseLong(initArr[2]));

    while (sc.hasNextLine()) {
      String[] inputArr = tokenize(sc.nextLine());

      if (inputArr[0].equals("add")) {
        add(Long.parseLong(inputArr[1]), Long.parseLong(inputArr[2]));
        System.out.println("null");
      } else if (inputArr[0].equals("check")) {
        System.out.println(check());
      }
    }

    sc.close();
  }
}
