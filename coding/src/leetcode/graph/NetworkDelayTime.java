package leetcode.graph;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(temp -> temp.cost));

        List<Pair>[] adj = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] time: times) {
            adj[time[0]].add(new Pair(time[1], time[2]));
        }

        pq.add(new Pair(k, 0));
        boolean[] vis = new boolean[n+1];
        vis[k] = true;
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            vis[pair.from] = true;
            cost[pair.from] = Math.min(pair.cost, cost[pair.from]);

            int sum = pair.cost == -1 ? 0: pair.cost;
            for (Pair neighbour : adj[pair.from]) {
                if (!vis[neighbour.from]) {
                    pq.add(new Pair(neighbour.from, Math.min(sum+neighbour.cost, cost[neighbour.from])));
                }
            }
        }

            for (int i = 0; i < n + 1; i++) {
                System.out.print(cost[i]+" ");
            }
            System.out.println();

        int max = 0;
        for (int i = 1; i < n+1; i++) {
            if (cost[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(i, max);
        }

        return max;
    }

    static class Pair {
        int from, cost;

        public Pair(int from, int cost) {
            this.from = from;
            this.cost = cost;
        }
    }
}
