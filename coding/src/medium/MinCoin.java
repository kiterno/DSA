package medium;

import java.util.Arrays;

public class MinCoin {
    public static void main(String[] args) {
        int[]  coins = {25, 10, 5};
        int V = 40;

        System.out.println(getMinCoin(coins, V, coins.length-1, 0));
        System.out.println(getMinCoin(coins, V));
        coins = new int[]{9, 6, 5, 1};
        V = 12;
        System.out.println(getMinCoin(coins, V, coins.length-1, 0));
        System.out.println(getMinCoin(coins, V));
    }

    private static int getMinCoin(int[] coins, int v, int i, int count) {
        if (v == 0) return count;

        if (v<0) return Integer.MAX_VALUE;
        if (i<0) return Integer.MAX_VALUE;

        return Math.min(getMinCoin(coins, v, i-1, count), getMinCoin(coins, v-coins[i],  i,count+1));
    }

    private static int getMinCoin(int[] coins, int v) {
        int n = coins.length;
        int[] dp = new int[v+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= v; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <=  i) {
                    int min = dp[i-coins[j]];

                    if(min != Integer.MAX_VALUE && min+1<dp[i])
                        dp[i] = min+1;
                }
            }
        }

        return dp[v] == Integer.MAX_VALUE ? -1 : dp[v];
    }
}
