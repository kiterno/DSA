package leetcode.practice;

import java.util.*;

public class Bfs {
    static int n;
    static List<Integer>[] adj;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0;i<n-1;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }
        
        
        printbfs(adj, n, 2);
    }

    private static void printbfs(List<Integer>[] adj, int n, int src) {
        boolean[] vis = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        List<Integer> traversed = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            traversed.add(curr);
            vis[curr] = true;

            for (int child: adj[curr]) {
                if (!vis[child]) queue.add(child);
            }
        }

        System.out.println(traversed);
    }
}
