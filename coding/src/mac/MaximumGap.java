package mac;

public class MaximumGap {
    public int maximumGap(int[] nums) {

        int max = nums[0];
        for(int i:nums) {
            max = Math.max(i, max);
        }


        int exp = 1, R = 10;

        int[] aux = new int[nums.length];
        while (max/exp > 0) {
            int[] count = new int[R];

            for (int i=0; i<nums.length; i++) {
                count[(nums[i]/exp) % 10]++;
            }

            for(int i=1;i<R;i++) {
                count[i]+=count[i-1];
            }

            for (int i=nums.length-1;i>=0;i--) {
                aux[--count[(nums[i]/exp) % 10]] = nums[i];
            }

            for (int i=0;i<nums.length;i++) {
                nums[i] = aux[i];
            }

            exp = exp * 10;
        }

        int m = Integer.MIN_VALUE;

        for (int i=1;i<nums.length;i++) {
            m = Math.max(m, nums[i]-nums[i-1]);
        }

        return m;
    }
}
