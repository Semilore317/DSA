// LeetCode #532 - K-diff Pairs in an Array

import java.util.*;

public class KDiffPairs {
    public int findIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).sorted();
        int count = 0;
        for (int i : nums) {
            for (int j : nums) {
                // create pair
                if (i - j == k && Arrays.binarySearch(nums, i) != Arrays.binarySearch(nums, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;
        problem_532 obj = new problem_532();
        System.out.println(obj.findPairs(nums, k));
    }
}
