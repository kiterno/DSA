package leetcode.practice.binarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int low = 0, high = m*n-1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            if (matrix[mid/n][mid%n] == target) {
                return true;
            } else if (matrix[mid/n][mid%n] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
