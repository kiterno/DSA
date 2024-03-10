package google.com.graph;

import java.util.ArrayList;

public class UnDirectedGraphCycle {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(isCycleUtil(adj, vis, i, -1))
                    return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src, int parent) {

        vis[src] = true;

        for(Integer list: adj.get(src)) {
            if(!vis[src])
                if(isCycleUtil(adj, vis, list, src))
                    return true;

            else if(list != parent)
                return true;
        }

        return false;
    }
}
