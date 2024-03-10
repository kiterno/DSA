package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestFlightRoute {
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp1 = br.readLine().split(" ");
        int n = Integer.parseInt(inp1[0]);
        int m = Integer.parseInt(inp1[1]);

        adj = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-->0) {
            String[] inp2 = br.readLine().split(" ");
            int u = Integer.parseInt(inp2[0]);
            int v = Integer.parseInt(inp2[1]);

            adj[u].add(v);
        }

        Queue<Pair> queue = new LinkedList<>();
        int[] parent = new int[n+1];
        boolean[] vis = new boolean[n+1];
        int[] count = new int[n+1];

        queue.add(new Pair(1, 0));
        count[1] = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            vis[pair.child] = true;

            if (count[pair.child] < count[pair.parent]+1) {
                parent[pair.child] = pair.parent;
                count[pair.child] = count[pair.parent]+1;
            }

            for(int neighbour: adj[pair.child]) {
                if (!vis[neighbour]) {
                    queue.add(new Pair(neighbour, pair.child));
                } else {

                    if (count[neighbour] < count[pair.child]+1) {
                        parent[neighbour] = pair.child;
                        count[neighbour] = count[pair.child]+1;
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        if (parent[n] == 0){
            System.out.println("IMPOSSIBLE");
            return;
        }

        while (n!= 1) {
            n = parent[n];
            stack.push(n);
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    static class Pair {
        int child, parent;

        public Pair(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }
}
