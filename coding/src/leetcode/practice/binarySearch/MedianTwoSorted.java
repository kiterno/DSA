package leetcode.practice.binarySearch;

public class MedianTwoSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int n = nums1.length, m = nums2.length;

        int low = 0, high = n;

        while (low<=high) {
            int partitionA = (low+high)/2;
            int partitionB = (m+n+1)/2 - partitionA;

            int leftMaxA = partitionA == 0 ? Integer.MIN_VALUE: nums1[partitionA-1];
            int rightMinA = partitionA == n ? Integer.MAX_VALUE: nums1[partitionA];
            int leftMaxB = partitionB == 0 ? Integer.MIN_VALUE: nums2[partitionB-1];
            int rightMinB = partitionB == m ? Integer.MAX_VALUE: nums2[partitionB];

            if (leftMaxA<=rightMinB && leftMaxB<=rightMinA) {
                if ((m+n)%2 == 0) {
                    return (Math.min(rightMinA, rightMinB) + Math.max(leftMaxA, leftMaxB)) / 2.0;
                } else {
                    return Math.max(leftMaxA, leftMaxB);
                }
            } else if (leftMaxA > rightMinB) {
                high = partitionA-1;
            } else {
                low = partitionA+1;
            }
        }

        return 0.0;
    }
}
