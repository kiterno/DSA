package google.com.dp;

public class AirthmaticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        int slice = 0;
        int prev = 0;

        for(int i=2;i<nums.length;i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                slice+=++prev;
            }
            else
                prev = 0;
        }
        return slice;
    }
}
