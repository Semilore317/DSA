// Fundamentals - EuclideanAlgorithm
package dsa.fundamentals;

public class EuclideanAlgorithm {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 287;
        int b = 91;
        EuclideanAlgorithm e = new EuclideanAlgorithm();
        System.out.println(e.gcd(a, b));
    }
}
