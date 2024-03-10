package google.com.twopointer;

public class MoveZeroes {
    //  [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        int number = 0;
        int zero = 0;

        while (number<nums.length) {
            while (number<nums.length && nums[number]==0) {
                number++;
            }
            while (zero<nums.length && nums[zero]!=0) {
                zero++;
            }
            swap(nums, number, zero);
        }
    }

    private void swap(int[] nums, int number, int zero) {
        if(number<nums.length && zero<nums.length) {
            int temp = nums[number];
            nums[number] = nums[zero];
            nums[zero] = temp;
        }
    }
}
