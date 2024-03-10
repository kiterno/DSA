package leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int edges = sc.nextInt();

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
        }

        dfs(2, n, adj);
    }

    private static void dfs(int src, int n, List<Integer>[] adj) {
        boolean[] vis = new boolean[n];

        dfs(src, vis, adj);
        System.out.println();
    }

    private static void dfs(int src, boolean[] vis, List<Integer>[] adj) {
        vis[src] = true;
        System.out.print(src+" ");
        for (int child: adj[src]) {
            if (!vis[child]) dfs(child, vis, adj);
        }
    }
}
