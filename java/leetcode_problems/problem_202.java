package leetcode_problems;

import java.util.HashSet;
//
public class problem_202 {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            // If we've seen this sum before, we're in a cycle, so return false
            if (!seen.add(n)) {
                return false;
            }

            // Calculate the sum of squared digits
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            // Update n to the new sum for the next iteration
            n = sum;
        }

        return true; // Return true if n becomes 1
    }

    public static void main(String[] args) {
        int n = 2;
        problem_202 object = new problem_202();
        System.out.println(object.isHappy(n)); // Output: false
    }
}