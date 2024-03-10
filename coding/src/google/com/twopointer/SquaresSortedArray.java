package google.com.twopointer;

import java.util.Arrays;

public class SquaresSortedArray {
    public static void main(String[] args) {
        SquaresSortedArray squaresSortedArray=new SquaresSortedArray();
        int[] nums = {-4, -3, 0, 2, 7};
        squaresSortedArray.sortedSquares(nums);
        squaresSortedArray.print(nums);

        nums = new int[]{-4, -1, 0, 3, 10};
        squaresSortedArray.sortedSquares(nums);
        squaresSortedArray.print(nums);

        nums = new int[]{-5, -4, 0, 2, 3};
        squaresSortedArray.sortedSquares(nums);
        squaresSortedArray.print(nums);
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }


    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    private void swap(int[] nums, int i, int pointer) {
        int temp = nums[i];
        nums[i] = nums[pointer];
        nums[pointer] = temp;
    }
}
