package leetcode.practice.coloring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
//                if (!coloring(i, graph, vis, color)) {

                if (!bipartiteDFS(color, graph, vis, 0, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean coloring(int src, int[][] graph, boolean[] vis, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        color[src] = 0;
        queue.add(src);

        for(int neighbours: graph[src]) {
            if (!vis[neighbours]) {
                if (!coloring(neighbours, graph, vis, color)) {
                    return false;
                }
            } else if (color[src] == color[neighbours]) {
                return false;
            }
        }

        return true;
    }

    private static boolean bipartiteDFS(int[] color, int[][] graph, boolean[] vis, int currentColor, int node) {
        vis[node] = true;
        color[node] = currentColor;

        for(int child: graph[node]) {
            if (!vis[child]) {
                if (!bipartiteDFS(color, graph, vis, currentColor^1, child)) {
                    return false;
                }
            } else {
                if (color[child] == color[node]) return false;
            }
        }

        return true;
    }
}
