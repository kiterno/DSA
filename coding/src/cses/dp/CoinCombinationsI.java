package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinCombinationsI {
    static int mod = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        int[] coins = new int[n];
        String[] input2 = br.readLine().split(" ");
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(coins);

        for (int i = 1; i <= x; i++) {
            dp[i] = 0;
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) break;

                dp[i] += dp[i-coins[j]];

                if(dp[i]>mod)
                    dp[i] -= mod;
            }
        }

        System.out.println(dp[x]);
    }
}
