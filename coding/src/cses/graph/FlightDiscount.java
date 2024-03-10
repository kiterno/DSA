package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FlightDiscount {
    static List<List<Flight>> adj = new ArrayList<>();
    static List<List<Flight>> revAdj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");

            int a = Integer.parseInt(input2[0])-1;
            int b = Integer.parseInt(input2[1])-1;
            int c = Integer.parseInt(input2[2]);

            adj.get(a).add(new Flight(b, c));
            revAdj.get(b).add(new Flight(a, c));
        }

        long[] dist1 = minDist(0, adj);
        long[] dist2 = minDist(n-1, revAdj);

        long minCost = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for(Flight e: adj.get(i)) {
                minCost = Math.min(minCost, dist1[i] + dist2[e.to] + e.cost/2);
            }
        }

        System.out.println(minCost);
    }

    private static long[] minDist(int start, List<List<Flight>> adj) {
        long[] minDist = new long[adj.size()];
        boolean[] vis = new boolean[adj.size()];

        PriorityQueue<Flight> queue = new PriorityQueue<>((o1, o2) -> (int) (o1.cost-o2.cost));

        queue.add(new Flight(start, 0));
        while (!queue.isEmpty()) {
            Flight flight = queue.poll();

            if (!vis[flight.to]) {
                vis[flight.to] = true;
                minDist[flight.to] = flight.cost;

                for(Flight i: adj.get(flight.to)) {
                    queue.add(new Flight(i.to, flight.cost + i.cost));
                }
            }
        }
        return minDist;
    }

    static class Flight {
        int to;
        long cost;

        public Flight(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
