package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FlightRoutes {
    static List<Pair>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(input1[2]);

        adj = new List[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");

            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            adj[a].add(new Pair(b, c));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> Math.toIntExact(o1.to - o2.to));
        queue.add(new Pair(0, 1));
        List<Integer> dist = new ArrayList<>();

        int[] count = new int[n+1];

        int ctn = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int next = pair.cost;
            int sum = pair.to;

            if (count[next] > k) continue;
            count[next]++;

            if (next == n) {
                ctn++;
                dist.add(sum);
                if (ctn == k)
                    break;
            }

            for(Pair i: adj[next]) {
               if (count[i.to] > k)
                   continue;
               queue.add(new Pair(sum + i.cost, i.to));
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(dist.get(i)+" ");
        }
        System.out.println();
    }

    static class Pair {
        int to;
        int cost;

        public Pair(int to, int  cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
