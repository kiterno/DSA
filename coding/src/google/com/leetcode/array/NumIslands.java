package google.com.leetcode.array;

public class NumIslands {
    int possibleWays[][] = {{1,1}, {-1,-1}, {0, 1}, {1,0}, {-1, 1}, {1, -1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[m][n];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, i, j, m, n, vis);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] vis) {
        vis[i][j] = true;

        for(int k=0;k<8;k++){
            if(i+possibleWays[k][0] >= 0
                    && i+possibleWays[k][0]<m
                    && j+possibleWays[k][1] < n
                    && j+possibleWays[k][1]>=0
                    && !vis[i+possibleWays[k][0]][j+possibleWays[k][1]]
                    && grid[i+possibleWays[k][0]][j+possibleWays[k][1]] == '1'){
                dfs(grid, i+possibleWays[k][0], j+possibleWays[k][1], m, n, vis);
            }
        }
    }
}
