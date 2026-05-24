// LeetCode #74 - Search a 2D Matrix

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int column_Length = matrix[0].length;
        int right = matrix.length*column_Length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / column_Length;

            int col = mid % column_Length;

            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] < target) {
                left = mid + 1;
            }else if (matrix[row][col] > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the method
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        Search2DMatrix solution = new Search2DMatrix();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}