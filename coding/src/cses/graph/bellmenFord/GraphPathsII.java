package cses.graph.bellmenFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GraphPathsII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);

        List<Pair> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            adj.add(new Pair(a, b, c));
        }

        int[] cost = new int[n+1];

        for (int i = 0; i < k/2; i++) {
            for(Pair curr: adj) {
                if (cost[curr.src]+curr.weight > cost[curr.dest]) {
                    cost[curr.dest] = cost[curr.src] + curr.weight;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(cost[i]+" ");
        }
        System.out.println();
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
