import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result {
  public static void extraLongFactorials(int n) {
    BigInteger res = new BigInteger("1");

    if (n == 0 || n == 1) {
      System.out.println(1);
      return;
    }

    for (int i = 1; i <= n; i++) {
      res = res.multiply(BigInteger.valueOf(i));
    }

    System.out.println(res.toString());
  }

  public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(bufferedReader.readLine().trim());
      Result.extraLongFactorials(n);
      bufferedReader.close();
    }
  }
}
