class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    int left_product = 1;
    for (int i = 0; i < n; i++) {
      result[i] = left_product;
      left_product *= nums[i];
    }

    int right_product = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= right_product;
      right_product *= nums[i];
    }

    return result;
  }
}
