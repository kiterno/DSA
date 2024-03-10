package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShortestRoutesII {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int q = Integer.parseInt(input1[2]);

        dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            if (c<dp[a][b]) dp[a][b] = dp[b][a] = c;
        }
        
        floyedWarshell(dp, n);

        while (q-->0) {
            String[] query = br.readLine().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);
            if (x == y) {
                dp[x][y] = 0;
            }  else if (dp[x][y] == (int) 1e9) {
                dp[x][y] = -1;
            }

            System.out.println(dp[x][y]);
        }
    }

    private static void floyedWarshell(int[][] dp, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i+1; j <= n; j++) {
                    dp[i][j] = dp[j][i] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }
    }
}
