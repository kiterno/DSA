package google.com.graph;

import java.util.ArrayList;

public class NumberOfProvince {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Integer>[] adj = new ArrayList[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if(i!=j && isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        int v = isConnected.length;
        int count = 0;
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!vis[i]) {
                dfs(adj, vis, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(ArrayList<Integer>[] adj, boolean[] vis, int i) {
        vis[i] = true;

        for (int src: adj[i]) {
            if(!vis[src])
                dfs(adj, vis, src);
        }
    }
}
