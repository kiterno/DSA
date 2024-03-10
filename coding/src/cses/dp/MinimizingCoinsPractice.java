package cses.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoinsPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), sum = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[sum+1];
        Arrays.fill(dp, sum+1);
        dp[0] = 0;

        for(int i=0;i<n;i++) {
            for (int j=coins[i];j<=sum;j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[sum] == sum+1? -1: dp[sum]);
    }
}
