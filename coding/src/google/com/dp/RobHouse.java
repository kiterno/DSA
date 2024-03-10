package google.com.dp;

public class RobHouse {
    public int rob(int[] nums) {
        int l = nums.length;

        if(l == 1)
            return nums[0];

        int s1 = rob(nums, 0, l-2);
        int s2 = rob(nums, 1, l-1);

        return Math.max(s1, s2);
    }

    private int rob(int[] nums, int start, int end) {
        int a = 0, b = nums[start];

        for (int i = 1+start; i <= end; i++) {
            int c = Math.max(a+nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}
