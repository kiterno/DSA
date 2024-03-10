package leetcode.practice.binarySearch;

public class KokoEatingBananas {
    /*
        Input: piles = [30,11,23,4,20], h = 6
        Output: 23
     */
    public static int minEatingSpeed(int[] piles, int h) {

        int low = 0, high = Integer.MAX_VALUE;

        while (low<=high) {
            int mid = low + (high-low)/2;

            long minSpeed = calculateTime(mid, piles);
            if (minSpeed > h) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low;
    }

    private static long calculateTime(int mid, int[] piles) {
        long sum = 0;

        for (int i: piles) {
            sum += (long) Math.ceil((double) i /mid);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;

        System.out.println(minEatingSpeed(piles, h));
    }
}
