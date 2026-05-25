class TwoSumII {
  public static int[] twoSum(int[] numbers, int target) {
    // since the array is sorted we can pull a few tricks

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      int sum = numbers[left] + numbers[right];

      if (sum == target) {
        return new int[] { left + 1, right + 1 };
      } else if (sum < target) {
        // a larger sum is required
        left++;
      } else if (sum > target) {
        // a smaller sum is required
        right--;
      }
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    int[] numbers = { -10, -8, -2, 1, 2, 5, 6 };
    int target = 0;

    System.out.println(twoSum(numbers, target));
    int[] solution = twoSum(numbers, target);
    System.out.println(solution[0]);
    System.out.println(solution[1]);
  }
}
