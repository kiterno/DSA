package cses.dp;

import java.util.Arrays;
import java.util.Scanner;

public class RemovalGame {
    static int size = 5005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

       long[][] dp = new long[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(findOptimal(a, dp, 0, n-1));
    }

    private static long findOptimal(int[] a, long[][] dp, int start, int end) {
        if (start>end) return 0;

        if (dp[start][end] != -1) return dp[start][end];

        long o1 = a[start] + Math.min(findOptimal(a, dp, start+2, end), findOptimal(a, dp,start+1, end-1));
        long o2 = a[end] + Math.min(findOptimal(a, dp, start, end-2), findOptimal(a, dp, start+1, end-1));

        dp[start][end] = Math.max(o1, o2);

        return dp[start][end];
    }
}
