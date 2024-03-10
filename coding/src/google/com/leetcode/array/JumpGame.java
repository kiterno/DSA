package google.com.leetcode.array;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxJump = 0;

        for(int i=0;i<nums.length;i++){
            if(maxJump<i)
                return false;

            maxJump = Math.max(maxJump, i+nums[i]);
        }
        return true;
    }

    public int jump(int[] nums) {
        int count = 0, maxJump = 0, currJump = 0;
        for(int i=0;i<nums.length-1;i++){

            maxJump = Math.max(maxJump, i+nums[i]);

            if(i == currJump) {
                count++;
                currJump = maxJump;
            }
        }

        return count;
    }
}
