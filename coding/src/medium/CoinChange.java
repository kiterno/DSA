package medium;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 4;

        int count = count(coins, sum, coins.length-1);
        System.out.println(count);
        System.out.println(count(coins, sum));
    }

    private static int count(int[] coins, int sum, int i) {
        if (sum == 0) return 1;

        if (sum<0) return 0;

        if (i<0) return 0;

        return count(coins, sum, i-1) + count(coins, sum-coins[i], i);
    }

    private static int count(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] += dp[i-1][j];
                if(j-coins[i-1] >= 0) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
