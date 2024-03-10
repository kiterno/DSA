package google.com.binary.search;

public class MinInRotatedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            if (nums[mid] < nums[high]) {
                high = mid - 1;
            }
            else low = mid +1;
        }
        return low;
    }
}
