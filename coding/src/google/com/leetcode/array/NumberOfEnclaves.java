package google.com.leetcode.array;

public class NumberOfEnclaves {
    int[][] possibleWays = {{0, 1}, {1,0}, {-1, 0}, {0, -1}};

    public int numEnclaves(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[m][n];
        for (int i=0;i<m;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid, i, 0, m, n, vis);
            }
            if(grid[i][n-1] == 1 && !vis[i][n-1]){
                dfs(grid, i, n-1, m, n, vis);
            }
        }
         for(int j=0;j<n;j++){
             if(grid[0][j] == 1 && !vis[0][j]){
                 dfs(grid, 0, j, m, n, vis);
             }
             if(grid[m-1][j] == 1 && !vis[m-1][j]){
                 dfs(grid, m-1, j, m, n, vis);
             }
         }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!vis[i][j] && grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, boolean[][] vis) {
        vis[i][j] = true;

        for(int k=0;k<possibleWays.length;k++){
            if(i+possibleWays[k][0] >= 0
                    && i+possibleWays[k][0]<m
                    && j+possibleWays[k][1] < n
                    && j+possibleWays[k][1]>=0
                    && !vis[i+possibleWays[k][0]][j+possibleWays[k][1]]
                    && grid[i+possibleWays[k][0]][j+possibleWays[k][1]] == 1){
                dfs(grid, i+possibleWays[k][0], j+possibleWays[k][1], m, n, vis);
            }
        }
    }
}
