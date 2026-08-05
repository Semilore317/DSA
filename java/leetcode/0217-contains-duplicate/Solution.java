// LeetCode #217 - Contains Duplicate

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) { // returns false if item already exists
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 1 };
    System.out.println(containsDuplicate(arr));
  }
}
