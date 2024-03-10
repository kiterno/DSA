package cses.dp;

import java.util.Scanner;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) dp[i][j] = 0;

                else {
                    int ans = Integer.MAX_VALUE;

                    for (int k = 1; k < i; k++) {
                        ans = Math.min(ans, 1+ dp[i-k][j] + dp[k][j]);
                    }
                    for (int k = 1; k < j; k++) {
                        ans = Math.min(ans, 1 + dp[i][j-k] + dp[i][k]);
                    }

                    dp[i][j] = ans;
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
