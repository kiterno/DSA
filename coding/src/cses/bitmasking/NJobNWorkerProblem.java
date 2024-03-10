package cses.bitmasking;

import java.util.Arrays;
import java.util.Scanner;

public class NJobNWorkerProblem {

    static int[][] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        dp = new int[21][(1<<21)];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(0, (1<<n)-1 , n, arr ));
    }

    private static int solve(int i, int mask, int n, int[][] arr) {
        if (i == n) {
            return 0;
        }

        if (dp[i][mask] != -1)
            return dp[i][mask];

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((mask & (1<<j)) != 0) {
                answer = Math.min(arr[j][i] + solve(i+1, (mask^(1<<j)), n, arr), answer);
            }
        }
        dp[i][mask] = answer;
        return dp[i][mask];
    }
}
