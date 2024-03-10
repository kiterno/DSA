package google.com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        boolean vis[] = new boolean[graph.V];

        int level = level(graph.adj, 0, vis, 4);
    }

    private static int level(ArrayList<Integer>[] adj, int start, boolean[] vis, int target) {
        Queue<Integer> queue = new LinkedList<>();
        vis[start] = true;
        queue.add(start);
        int height = 1;

        return 1;
    }
}
