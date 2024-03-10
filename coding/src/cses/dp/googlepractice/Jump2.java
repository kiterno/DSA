package cses.dp.googlepractice;

public class Jump2 {
    public int jump(int[] nums) {
        int curr = 0, maxJump =0;

        int count = 0;

        for(int i=0;i<nums.length;i++) {
            maxJump = Math.max(maxJump, nums[i]+i);

            if(i == curr) {
                count++;
                curr = maxJump;
            }
        }

        return count;
    }
}
