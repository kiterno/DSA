package google.com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {

    static class Graph {
        int V;
        ArrayList<Integer>[] adjMat;

        Graph(int V) {
            this.V = V;
            adjMat = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjMat[i] = new ArrayList<>();
            }
        }

        void addEdge(int v, int w) {
            adjMat[v].add(w);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        bfs(graph);
    }

    private static void bfs(Graph graph) {
        boolean vis[] = new boolean[graph.V];

        bfs(graph, 2, vis);
        Arrays.fill(vis, false);
        dfs(graph, 2, vis);
        System.out.println();
    }

    private static void dfs(Graph graph, int start, boolean[] vis) {
        vis[start] = true;
        System.out.printf(start+ " ");

        for(int i: graph.adjMat[start]) {
            if (!vis[i]) {
                dfs(graph, i, vis);
            }
        }
    }

    private static void bfs(Graph graph, int start, boolean[] vis) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        vis[start] = true;

        while (!queue.isEmpty()) {
            int s = queue.poll();
            System.out.print(s+" ");

            for (int i: graph.adjMat[s]) {
                if(!vis[i]) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
        System.out.println();
    }


}
