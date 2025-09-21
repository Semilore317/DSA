package leetcode_problems;

import java.util.Arrays;

public class problem_164 {
    public int maximumGap(int[] nums) {
        // return the max gap of any two sucessive elements in the array
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int max_gap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i+1] - nums[i] > max_gap) {
                max_gap = nums[i+1] - nums[i];
            }
        }
        return max_gap;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        problem_164 test = new problem_164();
        System.out.println(test.maximumGap(nums));
    }
}
