package google.com.leetcode.array;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        long mod = 2000000000;
        long dp[][]=new long[m+1][n+1];

        for(int i=0;i<m;i++)
            dp[i][0] = 1;
        for(int j=0;j<n;j++)
            dp[0][j]=1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = (dp[i-1][j]%mod+dp[i][j-1]%mod)%mod;
            }
        }
        return (int)(dp[m][n]%mod);
    }
}
