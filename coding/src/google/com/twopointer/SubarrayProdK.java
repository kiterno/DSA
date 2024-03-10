package google.com.twopointer;

public class SubarrayProdK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int prod = 1, total = 0, left = 0;

        for(int i=0;i<nums.length; i++) {
            prod = prod * nums[i];

            while (prod>=k) {
                prod = prod/nums[left++];
            }

            total += i-left+1;
        }
        return total;
    }
}
