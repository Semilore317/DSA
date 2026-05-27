import java.util.Arrays;

public class ContainsDuplicateRe {
  public static boolean containsDuplicate(int[] nums) {
    boolean res = false;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        res = true;
        break;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(containsDuplicate(nums));
  }
}
