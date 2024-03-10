package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuildingTeams {
    static List<Integer>[] adj;

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

        int[] color = new int[n+1];
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            color[i] = -1;
        }

        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (!vis[i])
                flag = flag & bipartiteDFS(color, vis, 0, i);

            if (!flag)
                break;
        }

        if (!flag) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print((color[i] == 0? "1": "2") +" ");
            }
        }
    }

    private static boolean bipartiteDFS(int[] color, boolean[] vis, int currentColor, int node) {
        vis[node] = true;
        color[node] = currentColor;

        for(int child: adj[node]) {
            if (!vis[child]) {
                if (!bipartiteDFS(color, vis, currentColor^1, child)) {
                    return false;
                }
            } else {
                if (color[child] == color[node]) return false;
            }
        }

        return true;
    }
}
