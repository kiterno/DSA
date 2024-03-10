package leetcode.practice;

import java.util.*;

public class Dikstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Pair>[] adj = new List[n];

        int edges = sc.nextInt();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (edges-->0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();

            adj[u].add(new Pair(v, cost));
            adj[v].add(new Pair(u, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        pq.add(new Pair(0, 0));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            distance[curr.dest] = Math.min(distance[curr.dest], curr.weight);

            for(Pair child: adj[curr.dest]) {
                if (distance[curr.dest] + child.weight < distance[child.dest]) {
                    pq.add(new Pair(child.dest, distance[curr.dest] + child.weight ));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(distance[i]+" ");
        }
        System.out.println();
    }

    static class Pair {
        int dest, weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}

/*
9
14
0 1 4
0 7 8
1 7 11
1 2 8
7 8 7
7 6 1
2 8 2
8 6 6
2 5 4
2 3 7
6 5 2
3 5 14
5 4 10
3 4 9
 */
