import java.util.Scanner;

public class Main {

  public static double add(double a, double b) {
    return a + b;
  }

  public static double subtract(double a, double b) {
    return a - b;
  }

  public static double multiply(double a, double b) {
    return a * b;
  }

  public static double divide(double a, double b) {
    return a / b;
  }

  static String formatResult(double x) {
    double rounded = Math.round(x * 1_000_000_0000L) / 1_000_000_0000.0;

    if (Math.abs(rounded - Math.rint(rounded)) < 1e-9) {
      return String.valueOf((long) Math.rint(rounded));
    }

    return String.valueOf(rounded);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();

    while (x > 0) {
      // take in stuff like 3+4
      double a = sc.nextDouble();
      String operator = sc.next();
      double b = sc.nextDouble();
      if (operator.equals("+")) {
        System.out.println(formatResult(add(a, b)));
      } else if (operator.equals("-")) {
        System.out.println(formatResult(subtract(a, b)));
      } else if (operator.equals("*")) {
        System.out.println(formatResult(multiply(a, b)));
      } else if (operator.equals("/")) {
        System.out.println(formatResult(divide(a, b)));
      }
      x--;
    }
    sc.close();
  }
}
