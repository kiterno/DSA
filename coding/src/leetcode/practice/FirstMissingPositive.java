package leetcode.practice;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i< n; i++) {
            if (nums[i]>=0 && nums[i]<n && nums[i] != i) {
                int t = nums[nums[i]-1];

                nums[nums[i]-1] = nums[i];
                nums[i] = t;
                if (nums[i]>=0 && nums[i]<n && nums[i] != nums[nums[i]-1])
                    i--;
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int j = 0; j < nums.length; j++) {

            if(nums[j] != j + 1) {
                return j + 1;
            }
        }

        return n;
    }
}
