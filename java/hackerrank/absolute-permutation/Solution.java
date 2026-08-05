// HackerRank - AbsolutePermutation

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[n + 1]; // to track used numbers

        for (int i = 1; i <= n; i++) {
            int x = i + k;
            int y = i - k;

            if (x <= n && !used[x]) {
                result.add(x);
                used[x] = true;
            } else if (y >= 1 && !used[y]) {
                result.add(y);
                used[y] = true;
            } else {
                return Arrays.asList(-1); // no valid permutation
            }
        }
        return result;
    }
}