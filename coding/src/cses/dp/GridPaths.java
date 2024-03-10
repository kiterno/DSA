//package cses.dp;

import java.util.Scanner;

public class GridPaths {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] ch = new char[n][n];

        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().toCharArray();
        }

        int[][] dp = new int[n][n];
        if (ch[0][0] == '*') {
            System.out.println("0");
            return;
        }

        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (ch[i][0] == '*') break;
            dp[i][0] = dp[i-1][0];
        }

        for (int i = 1; i < n; i++) {
            if (ch[0][i] == '*') break;
            dp[0][i] = dp[0][i-1];
        }

//        printdp(dp);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (ch[i][j] == '.') {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }

    private static void printdp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
