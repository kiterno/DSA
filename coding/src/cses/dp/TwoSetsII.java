package cses.dp;

import java.util.Scanner;

public class TwoSetsII {
    static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum =  n * (n+1) / 2;
        if (sum%2 == 0){
            int target = sum/2;
            int[][] dp = new int[n][target+1];

            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= target; j++) {
                    dp[i][j] = dp[i-1][j];

                    if (j>=i) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-i])%mod;
                    }
                }
            }

            System.out.println(dp[n-1][target]);
        } else {
            System.out.println("0");
        }
    }
}
