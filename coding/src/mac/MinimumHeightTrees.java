package mac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> adj = new ArrayList<>();

        for (int i=0;i<n;i++) adj.add(new HashSet<>());

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            if(adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }


        int remainingNodes = n;

        while (remainingNodes>2) {
            List<Integer> newLeaves = new ArrayList<>();
            remainingNodes -= leaves.size();

            for(int leave: leaves) {
                int neighbour = adj.get(leave).iterator().next();

                adj.get(neighbour).remove(leave);

                if (adj.get(neighbour).size() == 1) {
                    newLeaves.add(neighbour);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
