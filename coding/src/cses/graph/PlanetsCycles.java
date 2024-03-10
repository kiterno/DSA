package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanetsCycles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] inp = br.readLine().split(" ");
        int[] parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = Integer.parseInt(inp[i-1]);
        }

        int[] path = new int[n+1];
        Arrays.fill(path, 0);

        boolean[] vis = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            List<Integer> tempLoop = new ArrayList<>();
            if (!vis[i]) {
                dfs(tempLoop, i, parent, vis);

                if (tempLoop.size() == 1) {
                    if (i == parent[i]) {
                        path[i] = 1;
                    } else {
                        path[i] = path[parent[i]]+1;
                    }
                }
                if (!tempLoop.isEmpty()) {
                    storePathCount(tempLoop, path, parent);
                }
            }
            print(path);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }

    private static void storePathCount(List<Integer> tempLoop, int[] path, int[] parent) {
        int count = tempLoop.size();
        path[tempLoop.get(0)] = count;

        int diff = 1;
        for (int i = 0; i < tempLoop.size(); i++) {
            if (parent[tempLoop.get(tempLoop.size()-1)] == tempLoop.get(i)) {
                diff = 0;
            }

            path[tempLoop.get(i)] = count;
            count-=diff;
        }
    }

    private static void dfs(List<Integer> tempLoop, int i, int[] parent, boolean[] vis) {
        if (vis[i])
            return;
        vis[i] = true;
        tempLoop.add(i);
        dfs(tempLoop, parent[i], parent, vis);
    }

    private static void print(int[] path) {
        for (int i = 1; i < path.length; i++) {
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }
}
