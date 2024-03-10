package leetcode.practice.dp;

import java.util.StringTokenizer;

public class Interleaving {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), w = s3.length();
        int[][][] dp = new int[n+1][m+1][w+1];
        return isInterleave(s1, 0, s2, 0, s3, 0, dp);
    }

    private boolean isInterleave(String s1, int n, String s2, int m, String s3, int w, int[][][] dp) {
        if (dp[n][m][w] != 0) {
            return dp[n][m][w] == 1;
        }
        if(w>=s3.length() && n>=s1.length() && m >= s2.length()) {
            dp[n][m][w] = 1;
            return true;
        }

        if(w>=s3.length()) {
            dp[n][m][w] = 2;
            return false;
        }

        if(n<s1.length() && m<s2.length() && s1.charAt(n) == s2.charAt(m) && s1.charAt(n) == s3.charAt(w)) {
            dp[n][m][w] = (isInterleave(s1, n+1, s2, m, s3, w+1, dp) || isInterleave(s1, n, s2, m+1, s3, w+1, dp)) ? 1: 2;
            return dp[n][m][w] == 1;
        }

        if(n<s1.length() && s1.charAt(n) == s3.charAt(w)) {
            dp[n][m][w] = isInterleave(s1, n+1, s2, m, s3, w+1, dp)? 1: 2;
            return dp[n][m][w] == 1;
        } else if(m<s2.length() && s2.charAt(m) == s3.charAt(w)) {
            dp[n][m][w] = isInterleave(s1, n, s2, m+1, s3, w+1, dp)? 1: 2;
            return dp[n][m][w] == 1;
        }

        dp[n][m][w] = 2;
        return false;
    }

    private boolean isInterleaveDp(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), w = s3.length();

        boolean[][][] dp = new boolean[n+1][m+1][w+1];
        dp[n][m][w] = true;


        return true;
    }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        Interleaving i = new Interleaving();

        System.out.println(i.isInterleave(s1, s2, s3));
    }

}
