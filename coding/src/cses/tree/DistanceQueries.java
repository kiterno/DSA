package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceQueries {
    static int MS = 20;
    static int MX = (int) (2e5+5);
    static int[][] up = new int[MS][MX];
    static int[] depth = new int[MX];
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0].trim());
        int q = Integer.parseInt(input1[1].trim());

        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 2; i <= n; i++) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);

            adj[u].add(v);
            adj[v].add(u);
        }

        constructBinaryLifting(n);
//        printParent(up, n);
        for (int i = 0; i < q; i++) {
            String[] input3 = br.readLine().split(" ");
            int x = Integer.parseInt(input3[0]);
            int d = Integer.parseInt(input3[1]);

            System.out.println(LCA_SUM(x, d, i));
        }
    }

    private static int LCA_SUM(int x, int d, int i) {
        if (depth[x]<depth[d]) {
            int t = x;
            x = d;
            d = t;
        }

        int sum = depth[x] - depth[d];

        x = jump(x, sum);
//        System.out.println(" seven = " + x + " " + sum);
        if (x == d) {
            return sum;
        }

        for (int j = 18; j >= 0 ; j--) {
            int xT = up[j][x], dT = up[j][d];
            if (xT != dT) {
                sum+= (1<<j) * 2;
//                System.out.println("sum = " + sum + " " + j);
                x = xT;
                d = dT;
            }
        }

        return sum+2;
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
            Pair parent = queue.poll();
            vis[parent.first] = true;
            up[0][parent.first] = parent.parent;
            depth[parent.first] = parent.second;
            for (int i: adj[parent.first]) {
                if (!vis[i]) {
                    queue.add(new Pair(i, parent.second+1, parent.first));
                }
            }
        }

        for (int i = 1; i<MS; i++) {
            for (int j = 1; j <= n ; j++) {
                up[i][j] = up[i-1][up[i-1][j]];
            }
        }
    }

    public static void printParent(int[][] up, int n) {
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

    static class Pair {
        int first, second, parent;

        Pair(int first, int second, int parent) {
            this.first = first;
            this.second = second;
            this.parent = parent;
        }
    }
}
