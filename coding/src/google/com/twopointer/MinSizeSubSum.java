package google.com.twopointer;

public class MinSizeSubSum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, minLength= Integer.MAX_VALUE;
        int right;
        for (right = 0; right<nums.length; right++) {
            sum+=nums[right];
            while (sum>target){
                sum-=nums[left++];
                if(sum>=target)
                    minLength = Math.min(minLength, right-left+1);
            }

            if(sum >= target) {
                minLength = Math.min(minLength, right-left);
            }
        }

        while (sum>target){
            sum-=nums[left++];
            if(sum>=target)
                minLength = Math.min(minLength, right-left+1);
        }

        if(sum >= target) {
            minLength = Math.min(minLength, right-left);
        }

        return minLength == Integer.MAX_VALUE ? 0:minLength;
    }
}
