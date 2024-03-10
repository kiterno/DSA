package cses.matrixMultiplication;

public class MatrixMultiplication {
    public static void main(String[] args) {


        int n = 10;
        int[][] dp = new int[n][n];
        int value[] = new int[n];

        for(int k=2;k<n;k++) {
            for (int left = 0; left<n-k;left++) {
                int right = left+k;
                dp[left][right] = Integer.MAX_VALUE;

                for (int i = left+1; i < right; i++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][i]+dp[i][right]+value[left]*value[i]*value[right]);
                }
            }
        }

    }
}
