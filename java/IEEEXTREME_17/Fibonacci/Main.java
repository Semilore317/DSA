package IEEEXTREME_17.Fibonacci;

import java.util.Scanner;

class Main {
    public static int fibonacci(int n) {
        // Pisano period optimization — last digit repeats every 60 terms
        n = ((n - 1) % 60) + 1;

        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 3;
        else if (n == 4) return 5;

		int a = 3, b = 5, fib = 0;

        for (int i = 5; i <= n; i++) {
            fib = (a + b) % 10;  // only keep last digit
            a = b;
            b = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();  // number of test cases (1 <= t <= 100)
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int humans_left = fibonacci(m);
            System.out.println(humans_left);
        }

        scanner.close();
    }
}
