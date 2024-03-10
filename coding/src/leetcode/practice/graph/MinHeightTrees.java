package leetcode.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<2) {
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<n;i++) {
                res.add(i);
            }
            return res;
        }

        List<Set<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new HashSet<>());
        }

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remNodes = n;

        while(remNodes > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            remNodes -= leaves.size();
            for(int leave: leaves) {
                int neighbour = adj.get(leave).iterator().next();
                adj.get(neighbour).remove(leave);

                if(adj.get(neighbour).size() == 1) {
                    newLeaves.add(neighbour);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

}
