package leetcode.practice.binarySearch;

public class ShortestSubarraySumLeastK {
    public static int shortestSubarray(int[] nums, int k) {
        int count = Integer.MAX_VALUE;

        int i=0, j=0;
        int sum = 0;

        while (i<=j && j<nums.length) {
            sum += nums[j++];

            while (sum>=k && i<=j) {
                sum = sum - nums[i++];
                count = Math.min(count, j-i+1);
            }
        }

        return count == Integer.MAX_VALUE ? -1: count;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println(shortestSubarray(nums, k));

        nums = new int[] {1, 2}; k = 4;
        System.out.println(shortestSubarray(nums, k));

        nums = new int[] {1};
        System.out.println(shortestSubarray(nums, 1));

        nums = new int[] {84,-37,32,40,95};
        k = 167;
        System.out.println(shortestSubarray(nums, k));
    }
}
