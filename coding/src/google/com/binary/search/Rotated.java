package google.com.binary.search;

public class Rotated {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low<=high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
                return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[high]>=target && nums[mid]<=target){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new Rotated().search(nums, 0));
    }
}
