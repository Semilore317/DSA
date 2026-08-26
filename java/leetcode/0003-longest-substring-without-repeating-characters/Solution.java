import java.util.HashSet;
import java.util.Set;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty() || s == null)
      return 0;

    if (s.isBlank()) {
      return 1;
    }

    Set<Character> charSet = new HashSet<>();
    int maxLength = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
      // if duplicate is found, shrink the window from the left
      while (charSet.contains(s.charAt(right))) {
        charSet.remove(s.charAt(left));
        left++;
      }

      // add current character and update max length
      charSet.add(s.charAt(right));
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }
}
