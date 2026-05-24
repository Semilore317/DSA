// Fundamentals - BinarySearch

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binary_search obj = new binary_search();
        System.out.println(obj.binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 9));
    }
}
