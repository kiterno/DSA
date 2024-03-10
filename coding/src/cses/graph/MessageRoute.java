package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MessageRoute {

    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        adj = new List[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);

            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] res = new int[n+1];
        boolean[] vis = new boolean[n+1];

        vis[1] = true;
        while (!queue.isEmpty()) {
            int it = queue.poll();

            for(int i: adj[it]) {
                if (!vis[i]) {
                    res[i] = it;
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }

        if (res[n] == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        Stack<Integer> st = new Stack<>();
        while (n!=0) {
            st.push(n);
            n = res[n];
        }
        System.out.println(st.size());
        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
        System.out.println();
    }
}
