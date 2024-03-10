package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CycleFinding {
    static List<Cycle> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            adj.add(new Cycle(a, b, c));
        }

        long[] cost = new long[n+1];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[1] = 0;
        int ptr = 0;
        int[] parentArr = new int[n+1];
        //bellmen ford
        for (int i = 0; i <= n; i++) {
            ptr = 0;
            for(Cycle cycle: adj) {
                if (cost[cycle.from] != Long.MAX_VALUE && cost[cycle.from] + cycle.cost < cost[cycle.to]) {
                    cost[cycle.to] = cost[cycle.from] + cycle.cost;
                    parentArr[cycle.to] = cycle.from;
                    ptr = cycle.to;
                }
            }
        }


        if (ptr == 0) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < n; i++) {
                ptr = parentArr[ptr];
            }

            System.out.println("YES");
            List<Integer> cycle = new ArrayList<>();

            for (int i = ptr;; i = parentArr[i]) {
                cycle.add(i);
                if (i == ptr && cycle.size()>1) break;
            }
            for(int i: cycle)
                System.out.print(i+" ");
            System.out.println();
        }
    }

    static class Cycle {
        int from, to, cost;

        public Cycle(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
