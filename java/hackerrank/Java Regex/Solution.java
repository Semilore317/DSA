import java.util.Scanner;

public class Solution {

  public static boolean isValidIp(String address) {

    if (address == null) {
      return false;
    }

    String[] arr = address.split("\\.");

    if (arr.length != 4) {
      return false;
    }

    for (String sub : arr) {
      if (sub.isEmpty()) {
        return false;
      }
      if (sub.length() > 3) {
        return false;
      }
      try {
        int x = Integer.parseInt(sub);
        if (x < 0 || x > 255) {
          return false;
        }
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */

    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.nextLine();
      System.out.println(isValidIp(input));
    }

    sc.close();
  }
}
