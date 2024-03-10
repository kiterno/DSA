package cses.dp;

import java.util.*;

public class ElevatorRides {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int[][] dp = new int[1 << n][2];
        dp[0][0] = 0;
        dp[0][1] = k + 1;

        for (int s = 1; s < (1 << n); s++) {
            dp[s][0] = 25;
            dp[s][1] = 0;

            for (int i = 0; i < n; i++) {
                if ((s & (1 << i)) != 0) {
                    int[] prev = Arrays.copyOf(dp[s ^ (1 << i)], 2);
                    if (prev[1] + a[i] > k) {
                        prev[0]++;
                        prev[1] = Math.min(a[i], prev[1]);
                    } else {
                        prev[1] += a[i];
                    }
                    dp[s][0] = Math.min(dp[s][0], prev[0]);
                    dp[s][1] = Math.max(dp[s][1], prev[1]);
                }
            }
        }

        System.out.println(dp[(1 << n) - 1][0]);
    }
}
