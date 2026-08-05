// LeetCode #55 - Jump Game

public class Solution {
    public boolean canJump(int[] nums) {
        /* GREEDY MF'ING APPROACH */

        int max_index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max_index) {
                return false;
            }
            max_index = Math.max(max_index, i + nums[i]);
            if (max_index >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution obj = new Solution();
        System.out.println(obj.canJump(nums));
    }
}
