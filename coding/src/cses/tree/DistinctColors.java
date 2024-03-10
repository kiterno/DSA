package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctColors {
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] val = new int[n+1];
        String[] input1 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            val[i+1] = Integer.parseInt(input1[i]);
        }
        adj = new List[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input2 = br.readLine().split(" ");

            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);

            adj[u].add(v);
            adj[v].add(u);
        }

        Set<Integer>[] set = new HashSet[n+1];

        for (int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
            set[i].add(val[i]);
        }

        boolean[] vis = new boolean[n+1];

        dfs(1, vis, set);
        for (int i = 1; i <= n; i++) {
            System.out.print(set[i].size()+" ");
        }
        System.out.println();
    }

    private static void dfs(int i, boolean[] vis, Set<Integer>[] set) {
        vis[i] = true;
        Set<Integer> temp = set[i];
        int high=-1;
        for(int val: adj[i]) {
            if (!vis[val]) {
                dfs(val, vis, set);
                if(temp.size()<set[val].size()){
                    temp=set[val];
                    high=val;
                }

            }
        }
        for(int val:adj[i]){
            if(!vis[val]){
                if(val!=high){
                    temp.addAll((set[val]));
                }
            }
        }
    }
}

