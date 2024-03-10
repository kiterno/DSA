package google.com.binary.search;

public class LIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(LIS.lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp =new int[nums.length];
        int len=0;

        for(int num: nums){
            int i=binarySearch(dp, 0, len, num);
            printArr(dp);

            if(i<0)
                i = -(i+1);
            System.out.println(i + " " + len);

            dp[i] = num;
            if(i==len)
                len++;
        }
        print(dp);
        return len;
    }

    public static int binarySearch(int arr[], int from, int to, int num) {
        int low = from, high = to - 1;

        while (low<=high) {
            int mid = low + (high - low)/2;
            System.out.println(low + " " + high +" "+mid);
            if(arr[mid] < num)
                low = mid + 1;
            else if(arr[mid] > num)
                high = mid -1;
            else return mid;
        }

        return -(low+1);
    }

    private static void printArr(int[] arr) {
        for (int i:arr)
            System.out.printf(i+" ");
        System.out.println();
    }

    private static void print(int[] dp) {
        for (int i:dp)
            System.out.printf(i+"\t");
        System.out.println();
    }
}
