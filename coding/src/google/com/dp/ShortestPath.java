package google.com.dp;

public class ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length, n=grid[0].length;

        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= m ; i++) {
            if(grid[i-1][0] == 0) {
                dp[i][0] = dp[i-1][0] + 1;
            } else {
                break;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(grid[0][i-1] == 0) {
                
            }
        }
        for(int i=1;i<=m;i++) {
            for (int j = 1; j <= n; j++) {
                if(i==1 || j==1) {

                }
            }
        }
        return 1;
    }
}
