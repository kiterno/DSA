package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Dikstra
public class ShortestRoutesI {
    static int[] dp;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        dp = new int[n+1];
        adj = new List[n+1];
        int[][] cost = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            adj[i] = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");

            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            adj[a].add(b);
            cost[a][b] = Math.min(c, cost[a][b]);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        pq.add(new Pair(1, 0));
        boolean[] vis = new boolean[n+1];
        dp[1] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            vis[pair.key] = true;
            for(int i: adj[pair.key]) {
                if (!vis[i]) {
                    dp[i] = Math.min(dp[i], dp[pair.key] + cost[pair.key][i]);
                    pq.add(new Pair(i, dp[i]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
    static class Pair {
        int key, cost;

        Pair(int key, int cost) {
            this.key = key;
            this.cost = cost;
        }
    }
}
