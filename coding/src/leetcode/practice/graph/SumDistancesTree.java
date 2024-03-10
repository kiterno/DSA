package leetcode.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDistancesTree {
    List<Integer>[] adj;
    public int[] sumOfDistanceInTree(int n, int[][] edges) {
        adj = new List[n];
        for (int i=0;i<n;i++) adj[i] = new ArrayList<>();

        int[] result = new int[n];

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n];
//        dfs(adj, result, 0, 0, vis);
        countNodes(adj, 0, result, vis);
        System.out.println(Arrays.toString(result));
        Arrays.fill(vis, false);
        getSum(adj, 0, result[0], result, n, vis);
        return result;
    }

    private void getSum(List<Integer>[] adj, int src, int sum, int[] result, int n, boolean[] vis) {
        result[src] = sum;
        vis[src] = true;

        for(int i: adj[src]) {
            if(!vis[i]) {
                sum = result[src] - result[i] + n - 2;
                getSum(adj, i, sum, result, n, vis);
            }

        }
    }

    private int dfs(List<Integer>[] adj, int[] result, int src, int depth, boolean[] vis) {
        vis[src] = true;

        for(int i: adj[src]) {
            if(!vis[i]) {
                result[src] += dfs(adj, result, i, depth+1, vis) + result[i];
            }

        }

        return depth;
    }

    private int countNodes(List<Integer>[] graph, int src, int[] countArr, boolean[] vis){
        vis[src] = true;
        int c = 1;
        for(int nbr : graph[src]){
            if(!vis[nbr]){
                c += countNodes(graph, nbr, countArr, vis);
            }
        }
        countArr[src] = c;
        return c;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};

        int n = 6;
//        System.out.println(Arrays.toString(new SumDistancesTree().sumOfDistanceInTree(n, edges)));
//
//        edges = new int[][] {{1,0}};
//        n = 2;
//        System.out.println(Arrays.toString(new SumDistancesTree().sumOfDistanceInTree(n, edges)));
//
//        edges = new int[][] {{2,0},{1,0}};
//        n = 3;
//        System.out.println(Arrays.toString(new SumDistancesTree().sumOfDistanceInTree(n, edges)));

        edges = new int[][] {{1,2},{3,2},{3,0}};
        n = 4;
        System.out.println(Arrays.toString(new SumDistancesTree().sumOfDistanceInTree(n, edges)));
    }
}
