package medium;

public class CountSubsetsX {
    static int counter = 0;

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 3, 4};
        int x = 10;

        countSubsetWithSum(arr, x);
        System.out.println(counter);
        System.out.println(subsetSum(arr, x));
    }

    private static void countSubsetWithSum(int[] arr, int x) {

        getSubsetSum(arr, x, 0);
    }

    private static void getSubsetSum(int[] arr, int x, int index) {
        if (index>=arr.length && x == 0) {
            counter++;
            return;
        }

        if(x<0 || index>=arr.length) {
            return;
        }

        getSubsetSum(arr, x, index+1);
        getSubsetSum(arr, x-arr[index], index+1);
    }

    static int subsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i-1]>j) dp[i][j] = dp[i-1][j];

                else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
