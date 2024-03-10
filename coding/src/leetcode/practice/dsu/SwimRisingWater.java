package leetcode.practice.dsu;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        boolean[][] vis = new boolean[n][m];

        return dikstra(grid, n, m, vis);
    }

    private int dikstra(int[][] grid, int n, int m, boolean[][] vis) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight-b.weight);

        pq.add(new Pair(0, 0, grid[0][0]));
        vis[0][0] = true;

        int min = grid[0][0];
        int[][] moves = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            if (min<pair.weight) {
                min = pair.weight;
            }

            if (pair.src == n-1 && pair.dest == m-1) {
                return min;
            }

            for(int[] move: moves) {
                int x = pair.src+move[0], y = pair.dest+move[1];
                if(x>=0 && y>=0 && x<n && y<m && !vis[x][y]) {
                    vis[x][y] = true;
                    pq.add(new Pair(x, y, grid[x][y]));
                }
            }
        }

        return min;
    }
    static class Pair {
        int src, dest, weight;

        public Pair(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
