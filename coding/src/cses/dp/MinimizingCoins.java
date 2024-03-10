package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimizingCoins {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        int[] coins = new int[n];
        String[] input2 = br.readLine().split(" ");
        long[] dp = new long[x+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(input2[i]);
            if (coins[i]<=x)
                dp[coins[i]] = 1;
        }
        Arrays.sort(coins);

        for (int i = 1; i <= x; i++) {
            if (dp[i] == 1) continue;

            for (int j = 0; j < n; j++) {
                if (coins[j]>i) break;

                dp[i] = Math.min(dp[coins[j]]+dp[i-coins[j]], dp[i]);
            }
        }

//        print(dp);

        System.out.println(dp[x] == Integer.MAX_VALUE ? -1: dp[x]);
    }

    private static void print(int[] dp) {
        for(int i: dp)
            System.out.print(i+" ");
        System.out.println();
    }
}
