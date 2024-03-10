package google.com.graph;

public class NumberOfIslands {
    private static int[][] paths = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int numIslands(char[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean vis[][] = new boolean[m][n];

        int count = 0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(grid, vis, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        vis[i][j] = true;
        for (int k = 0; k < paths.length; k++) {
            if((i+paths[k][0])>=0 && (i+paths[k][0])<m && (j+paths[k][1])>=0 && (j+paths[k][1])<n && !vis[i+paths[k][0]][j+paths[k][1]] && grid[i+paths[k][0]][j+paths[k][1]] == '1') {
                bfs(grid, vis, i+paths[k][0], j+paths[k][1], m, n);
            }
        }
    }
}
