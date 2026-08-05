// HackerRank - CustomSortedArray

import java.util.*;

public class Solution {
    public static void swapValues(List<Integer> list, int index1, int index2) {
        // check if indices are valid
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            // Swap values using a temporary variable
            int temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }

    public static int moves(List<Integer> list) {
        int n = list.size();
        int moves = 0;

        // count even numbers
        int evenCount = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // use two pointers: left for even numbers, right for odd numbers
        int left = 0;
        int right = n - 1;

        while (left < right) {
            // find the next odd number from the left
            while (left < right && list.get(left) % 2 == 0) {
                left++;
            }
            // find the next even number from the right
            while (left < right && list.get(right) % 2 == 1) {
                right--;
            }
            // if there's an odd number on the left and an even number on the right, swap them
            if (left < right) {
                swapValues(list, left, right);
                moves++;
                left++;
                right--;
            }
        }
        return moves;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] arr = {6, 3, 4, 5};
        list.addAll(Arrays.asList(arr));
        System.out.println(moves(list));
    }
}