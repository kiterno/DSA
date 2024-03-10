package google.com.array;

public class MinSize {
    public int minSubArrayLen(int target, int[] nums) {

        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (i<nums.length && j<nums.length) {
            while (sum<target) {
                sum+=nums[i++];
            }
            min = Math.min(min, i-j);

            while (sum>target && j<=i) {
                sum -= nums[j++];
            }
            min = Math.min(min, i-j+1);
        }

        return min;

    }
}
