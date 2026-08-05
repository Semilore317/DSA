// Fundamentals - LinearSearch
package dsa.fundamentals;

public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 4};
        int target = 9;
        int index = linearSearch(arr, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}// An optimized version of Bubble Sort
