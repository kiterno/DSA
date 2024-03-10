package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RoundTrip {
    static List<Integer>[] adj;
    static int loop = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        adj = new List[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-->0) {
            String[] input2 = br.readLine().split(" ");

            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] parent = new int[n+1];
        boolean[] vis = new boolean[n+1];

        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                flag = flag & dfs(vis, parent, 0, i);
            }

            if (loop != -1) {
                break;
            }
        }

        flag = false;
        if (loop == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            int curr = loop;
            List<Integer> arr = new ArrayList<>();
            while (!flag || curr != loop) {
                arr.add(curr);
                curr = parent[curr];
                flag = true;
            }
            arr.add(loop);
            System.out.println(arr.size());
            for(int i: arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static boolean dfs(boolean[] vis, int[] parent, int prev, int i) {

        vis[i] = true;
        parent[i] = prev;

        for (int child: adj[i]) {
            if (vis[child] && child!=prev) {
                loop = child;
                parent[child] = i;
                return false;
            }
            if (!vis[child]) {
                if (!dfs(vis, parent, i, child)) {
                    return false;
                }
            }
        }

        return true;
    }
}
