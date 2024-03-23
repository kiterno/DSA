package mac;

import java.util.ArrayList;
import java.util.List;

public class NumberProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j && isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i=0;i<n;i++) {
            if (!vis[i]) {
                dfs(vis, adj, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(boolean[] vis, List<Integer>[] adj, int src) {
        vis[src] = true;

        for (int i: adj[src]) {
            if (!vis[i]) {
                dfs(vis, adj, i);
            }
        }
    }
}
