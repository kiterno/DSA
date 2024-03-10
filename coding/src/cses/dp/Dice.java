package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dice {
    static int mod = (int) (10e9+7);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+2];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++) {

            int j = i-1;
            while(j>=i-6 && j>=0) {
                dp[i] = (dp[i]%mod + dp[j--]%mod);
            }
        }

        for (long i: dp) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println(dp[n]%mod);
    }
}
//1230725361
//1230725361