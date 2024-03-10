package google.com.graph;

public class NumberOfClosedIslands {
    int[][] path = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis=new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            if(!vis[i][0] && grid[i][0] == 0) {
                dfs(grid, vis, m, n, i, 0);
            }
            if(!vis[i][n-1] && grid[i][n-1] == 0) {
                dfs(grid, vis, m, n, i, n-1);
            }
        }

        for (int i = 0; i < n; i++) {
            if(!vis[0][i] && grid[0][i] == 0) {
                dfs(grid, vis, m, n, 0, i);
            }
            if(!vis[m-1][i] && grid[m-1][i] == 0) {
                dfs(grid, vis, m, n, m-1, i);
            }
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(!vis[i][j] && grid[i][j] == 0) {
                    dfs(grid, vis, m, n, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] vis, int m, int n, int i, int j) {
        vis[i][j] = true;

        for (int[] ints : path) {
            if ((i + ints[0] >= 0) && (i + ints[0] < m) && (j + ints[1] >= 0) && (j + ints[1] < n) && !vis[i + ints[0]][j + ints[1]] && grid[i + ints[0]][j + ints[1]] == 0) {
                dfs(grid, vis, m, n, i + ints[0], j + ints[1]);
            }
        }
    }

}