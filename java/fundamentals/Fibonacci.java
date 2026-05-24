// Fundamentals - Fibonacci

public class Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) return 1;
        return n * fibonacci(n - 1);

    }
    public static void main(String[] args) {
        int n = 8;
        Fibonacci obj = new Fibonacci();
        System.out.println(obj.fibonacci(n));
    }
}
