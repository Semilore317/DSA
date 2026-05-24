// LeetCode #15 - 3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers, int target) {
        Arrays.sort(numbers); // Sort the array for two-pointer technique
        List<List<Integer>> result = new ArrayList<>();
        int n = numbers.length;

        // {1,1,3,4,5,6}

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int left = i + 1, right = n - 1; // left and right pointer
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // Found a triplet
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    // Skip duplicates for left pointer
                    while (left < right && numbers[left] == numbers[left + 1]) { //
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && numbers[right] == numbers[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test the method
        int[] numbers = { -1, 0, 1, 2, -1, -4 };
        problem_15 solution = new problem_15();
        List<List<Integer>> result = solution.threeSum(numbers, 0); // Target is 0 for 3Sum
        System.out.println(result); // Expected: [[-1, -1, 2], [-1, 0, 1]]
    }
}