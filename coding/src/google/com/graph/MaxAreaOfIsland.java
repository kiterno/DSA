package google.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int area = new MaxAreaOfIsland().maxAreaOfIsland(grid);
        System.out.println(area);
    }

    public int maxAreaOfIsland(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        int[][] path = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if(!vis[i][j] && grid[i][j] == 1) {
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        vis[pair.x][pair.y] = true;
                        for (int k = 0; k < path.length; k++) {
                            if((pair.x+path[k][0]) >=0
                                    && (pair.x+path[k][0]) < m
                                    && (pair.y+path[k][1]) >=0
                                    && (pair.y+path[k][1]) < n
                                    && !vis[pair.x+path[k][0]][pair.y+path[k][1]]
                                    && grid[pair.x+path[k][0]][pair.y+path[k][1]] == 1) {
                                queue.add(new Pair(pair.x+path[k][0], pair.y+path[k][1]));
                                vis[pair.x+path[k][0]][pair.y+path[k][1]] = true;
                            }
                        }
                        sum++;
                    }
                    if(sum>count)
                        count = sum;
                }
            }
        }
        return count;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
