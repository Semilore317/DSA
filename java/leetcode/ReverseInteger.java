// LeetCode #7 - Reverse Integer

public class ReverseInteger {
    public int reverse(int x) {

        long finalNum = 0;

        while (x != 0) {
           int lastDigit = x % 10;
           finalNum += lastDigit;
           finalNum = finalNum * 10;
           x /= 10;
        }

        finalNum /= 10;

        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) finalNum;
    }

    public static void main(String[] args) {
        int x = new problem_7().reverse(-146);
        System.out.println(x);
    }
}
