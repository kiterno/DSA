package google.com.graph;

import java.util.ArrayList;

public class DirectedGraphCycle {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

        for (int i=0;i<V;i++)
            if(isCyclicUtil(adj, vis, rec, i))
                return true;

        return false;
    }

    private boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rec, int src) {
        if(rec[src])
            return true;
        if(vis[src])
            return false;

        vis[src] = true;
        rec[src] = true;

        for (Integer list: adj.get(src)) {
            if(isCyclicUtil(adj, vis, rec, list)){
                return true;
            }
        }

        rec[src] = false;
        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] vis, int src) {
        if(vis[src]) {
            return true;
        }
        vis[src] = true;

        for (Integer list: adj.get(src)) {
            if(vis[list])
                return true;
            return dfs(adj, v, vis, list);
        }

        return false;
    }
}
