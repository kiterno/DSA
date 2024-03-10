package google.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {

    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        /*
        1 1 1 0 0
        0 1 1 1 1
        0 0 0 0 0
        1 0 0 0 0
        1 1 0 1 1


        1 1 1 0 0
        0 0 1 1 1
        0 1 0 0 0
        1 0 1 1 0
        0 1 0 1 0


         */

        int res = new CountSubIslands().countSubIslands(grid1, grid2);
        System.out.println(res);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid1.length, n = grid1[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean exists = true;
                if(!vis[i][j] && grid2[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        if(grid1[pair.x][pair.y] != 1) {
                            exists = false;
                        }
                        vis[pair.x][pair.y] = true;
                        for (int[] direction: directions) {
                            if((pair.x+direction[0])>=0
                                    && (pair.x+direction[0])<m
                                    && (pair.y+direction[1])>=0
                                    && (pair.y+direction[1])<n
                                    && !vis[pair.x+direction[0]][pair.y+direction[1]]
                                    && grid2[pair.x+direction[0]][pair.y+direction[1]] == 1) {
                                queue.add(new Pair( pair.x+direction[0], pair.y+direction[1]));
                                vis[pair.x+direction[0]][pair.y+direction[1]] = true;
                            }
                        }
                        System.out.println(queue);
                    }
                    if(exists)
                        result++;
                }

            }
        }
        return result;
    }
}
