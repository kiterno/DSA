package google.com.graph;

public class FloodFill {
    private static int[][] paths = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean vis[][] = new boolean[m][n];

        bfs(image, vis, sr, sc, m, n, color, image[sr][sc]);

        return image;
    }

    private void bfs(int[][] image, boolean[][] vis, int sr, int sc, int m, int n, int color, int type) {
        vis[sr][sc] = true;
        image[sr][sc] = color;

        for(int i=0;i<paths.length;i++) {
            if(isPossiblePath(image, vis, sr+paths[i][0], sc+paths[i][1], m, n, type)) {
                bfs(image, vis, sr+paths[i][0], sc+paths[i][1], m, n, color, type);
            }
        }
    }

    private boolean isPossiblePath(int[][] image, boolean[][] vis, int sr, int sc, int m, int n, int type) {
        if(sr>=0 && sr<m && sc>=0 && sc<n && image[sr][sc] == type && !vis[sr][sc])
            return true;
        return false;
    }
}
