package google.com.graph;

import java.util.ArrayList;

public class PathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        boolean[] vis = new boolean[n];

        bfs(adj, vis, source);
        return vis[source] == vis[destination];
    }

    private void bfs(ArrayList<Integer>[] adj, boolean[] vis, int source) {
        vis[source] = true;

        for(int neigh: adj[source]) {
            if(!vis[neigh])
                bfs(adj, vis, neigh);
        }
    }
}
