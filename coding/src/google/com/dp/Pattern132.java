package google.com.dp;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(nums[i], left[i-1]);
        }

        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > left[i] && nums[i] > right[i] && left[i] < right[i]) return true;
        }

        return false;
    }
}
