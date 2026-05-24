// LeetCode #66 - Plus One

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the rightmost digit (least significant)
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                // If the current digit is 9, set it to 0 and continue to the next digit (carry-over)
                digits[i] = 0;
            }
        }

        // If the loop completes, it means all digits were 9 (e.g., [9,9,9])
        // In this case, we need a new array with an additional digit at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // The new leading digit is 1 (e.g., [1,0,0,0])
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = {9,4,6,7,8};
        problem_66 object = new problem_66();
        int[] arr = object.plusOne(digits);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}