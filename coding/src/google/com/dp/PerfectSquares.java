package google.com.dp;

import java.util.*;

public class PerfectSquares {
    final int MAX_VAL = 10000;
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        getPerfectSquares(perfectSquares);

        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i:perfectSquares) {

            for (int j=i;j<=n;j++) {
                dp[i] = Math.min(dp[j-i]+1, dp[i]);
            }
        }

        return dp[n];
    }

    private void getPerfectSquares(List<Integer> perfectSquares) {
        int i = 1;

        while (i*i <= MAX_VAL) {
            perfectSquares.add(i*i);
            i++;
        }
    }
}
