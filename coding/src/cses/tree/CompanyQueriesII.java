package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CompanyQueriesII {
    static int MX = (int) (2e5 + 5);  // maximum N
    static int MS = 20;
    static int[] depth = new int[200005];// 18 is calculated by $\log_2 2e5$

    static int[][] up = new int[MS][MX];
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0].trim());
        int q = Integer.parseInt(input1[1].trim());
        String[] input2 = br.readLine().split(" ");
        adj = new ArrayList[n+1];
        for (int i = 0; i<=n; i++) {
            adj[i] = new ArrayList();
        }

        for (int i=2;i<=n;i++) {
            up[0][i] = Integer.parseInt(input2[i-2]);
            adj[up[0][i]].add(i);
            adj[i].add(up[0][i]);
        }

        constructBinaryLifting(n);
//        printParent(up, n);
        for (int i = 0; i < q; i++) {
            String[] queries = br.readLine().split(" ");
            int x = Integer.parseInt(queries[0].trim());
            int d = Integer.parseInt(queries[1].trim());
            System.out.println(LCA(x, d));
        }
    }

    private static int LCA(int x, int d) {
        if (depth[x]<depth[d]) {
            int t = x;
            x = d;
            d = t;
        }
//        System.out.println("x = " + x + " " + depth[x] + " " + depth[d]);
        x = jump(x, depth[x]-depth[d]);

        if (x == d) return x;

        for (int i = 18; i >= 0; i--) {
            int xT = up[i][x], dT = up[i][d];
            if (xT != dT) {
                x = xT;
                d = dT;
            }
        }
        return up[0][x];
    }

    private static void printParent(int[][] up, int n) {
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

    private static int jump(int x, int d) {
        for (int i = 0; i < MS; i++) {
            if (((d>>i) & 1) == 1) x = up[i][x];
        }
        return x == 0 ? -1 : x;
    }

    private static void constructBinaryLifting(int n) {
        for (int i = 1; i < MS; i++) {
            for (int j = 1; j <= n; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 1));
        boolean[] vis = new boolean[n+1];

        while (!queue.isEmpty()) {
            Pair parent = queue.poll();
            vis[parent.first] = true;
            depth[parent.first] = parent.second;
            for (int i: adj[parent.first]) {
                if (!vis[i]) {
                    queue.add(new Pair(i, parent.second+1));
                }
            }
        }
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
