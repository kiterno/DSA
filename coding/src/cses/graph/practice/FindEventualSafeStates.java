package cses.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] adj = new List[n];

        for (int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for (int i=0;i<n;i++) {
            for (int node: graph[i]) {
                adj[node].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            result.add(curr);

            for (int neighbour: adj[curr]) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }
}
