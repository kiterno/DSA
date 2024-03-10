package google.com.binary.search;

public class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int s = binarySearch3(nums, target);

        if(s>=nums.length || nums[s]!=target)
            return new int[]{-1, -1};
        return new int[]{s, binarySearch3(nums, target+1)-1};
    }

    public int binarySearch3(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low<=high) {
            int mid = low + (high - low) / 2;

            if(target>nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }


}
