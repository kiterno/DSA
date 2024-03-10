package leetcode.practice.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsMakeAllArrayElementsEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        List<Long> res = new ArrayList<>();

        long[] sum = new long[n];
        sum[0] = nums[0];
        for(int i=1;i<n;i++) sum[i] = sum[i-1] + nums[i];

        for(int i: queries) {
            int s = getIndex(nums, i, 0, n-1);
            long sumLeftRight = 0;
            sumLeftRight += s>0 ?((long)i * (long)s) - sum[s-1] :0;
            System.out.println(sumLeftRight + "  "+ s );
            sumLeftRight += s<n ? sum[n-1]-sum[s] - ((long)(n-s-1) * (long)i) :0;
            System.out.println(sumLeftRight + " " + ( sum[n-1]-sum[s]) + " " + (n-s));
            res.add(sumLeftRight);
        }

        return res;
    }

    private int getIndex(int[] nums, int i, int low, int high) {
        while(low < high) {
            int mid = low + (high-low)/2;

            if(i>nums[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,6,8}, queries = {1,5};

        System.out.println(new MinimumOperationsMakeAllArrayElementsEqual().minOperations(nums, queries));
        nums = new int[]{2,9,6,3};
        queries = new int[]{10};
//        System.out.println(new MinimumOperationsMakeAllArrayElementsEqual().minOperations(nums, queries));

    }
}
