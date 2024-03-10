package google.com.binary.search;

public class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            int mid_val = matrix[mid/m][mid%m];
            if(mid_val == target){
                return true;
            }
            else if (mid_val > target) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return false;
    }
}
