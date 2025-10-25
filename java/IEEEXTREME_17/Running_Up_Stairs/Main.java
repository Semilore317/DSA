package IEEEXTREME_17.Running_Up_Stairs;

import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static BigInteger fibonacci(int n){
        if (n == 0 || n == 1){
            return BigInteger.ONE;
        }

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for(int i = 2; i <= n; i++){
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        // the first input 1<=t<=5 is the number of testcases
        // the rest inputs 1<=n<=22,000 specifies the number of steps in the staircase
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t --> 0) {
            int m = scanner.nextInt();
            System.out.println(fibonacci(m));
        }
    }
}


// TODO: Add 19 problems 