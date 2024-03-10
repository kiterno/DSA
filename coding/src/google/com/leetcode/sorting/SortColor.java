package google.com.leetcode.sorting;

public class SortColor {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length-1;


        for(int i=0; i<nums.length/2;i++){
            if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
                two--;
            }
            else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}
