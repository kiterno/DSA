package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountingPaths {
    static int MX = (int) (2e5+5);
    static int MS = 18;
    static int[][] up;// up[i][j] j ka 2^ith parent
    static int[] depth;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int queries = Integer.parseInt(input1[1]);

        adj = new ArrayList[n+1];
        up = new int[MS][MX];
        depth = new int[n+1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 2; i <= n; i++) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        constructBinaryLifting(n);
//        displayBinaryLifting(n);

        int[] val = new int[n+1];
        for (int i = 0; i < queries; i++) {
            String[] input3 = br.readLine().split(" ");
            int u = Integer.parseInt(input3[0]);
            int v = Integer.parseInt(input3[1]);

            val[u] += 1;
            val[v] += 1;

            int p = LCA(u, v);
            if (p != 0) {
                val[p]--;
                if (up[0][p] != 0) {
                    val[up[0][p]] --;
                }
            }
        }

        boolean[] vis = new boolean[n+1];
        dfs(val, vis, 1);
        for (int i = 1; i <= n; i++) {
            System.out.print(val[i]+" ");
        }
        System.out.println();
    }

    private static int  dfs(int[] val, boolean[] vis, int i) {
        vis[i] = true;

        for(int j: adj[i]) {
            if (!vis[j])
                val[i] += dfs(val, vis, j);
        }

        return val[i];
    }

    private static int LCA(int x, int d) {
        if (depth[x] < depth[d]) {
            int t = x;
            x = d;
            d = t;
        }

        x = jump(x,  depth[x] - depth[d]);
        if (x == d) return x;

        for (int i = 17; i >= 0; i--) {
            int xT = up[i][x], dT = up[i][d];

            if (xT != dT) {
                x = xT;
                d = dT;
            }
        }

        return up[0][x];
    }

    private static int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if (((d>>i) & 1) == 1) x = up[i][x];
        }

        return x == 0 ? -1 : x;
    }

    private static void constructBinaryLifting(int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 1, 0));
        boolean[] vis = new boolean[n+1];

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            vis[pair.first] = true;
            depth[pair.first] = pair.depth;
            up[0][pair.first] = pair.parent;

            for (int i: adj[pair.first]) {
                if (!vis[i]) {
                    queue.add(new Pair(i, pair.depth +1, pair.first));
                }
            }
        }

        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }

        }
    }

    static class Pair {
        int first, depth, parent;

        public Pair(int first, int depth, int parent) {
            this.first = first;
            this.depth = depth;
            this.parent = parent;
        }
    }

    public static void displayBinaryLifting(int n) {
        for (int i = 0; i < MS; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(up[i][j]+" ");
            }
            System.out.println("DEPTH");
        }

        for (int i =0;i<=n;i++) {
            System.out.print(depth[i]+"\t");
        }
        System.out.println();
    }
}
