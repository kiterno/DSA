package cses.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesII {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        List<Integer>[] adj = new ArrayList[n+1];
        int[] indegree = new int[n+1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < relations.length; i++) {
            int u = relations[i][0];
            int v = relations[i][1];

            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] height = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                height[i] = 1;
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for(int i: adj[node]) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    height[i] = height[node]+1;
                    queue.add(i);
                }
            }
        }

        int max = 0;
        for (int i: height) {
            if (i>max)
                max = i;
        }

        int sum = 0;
        for(int i: height) {
//            System.out.println(i+ " " + Math.ceil((double) i/k) + " " + k);
            sum+= (int) Math.ceil((double) i/k);
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 11;
//        int[][] relations = {{2,1}, {3,1}, {1,4}};
        int[][] relations = {};
        System.out.println(new ParallelCoursesII().minNumberOfSemesters(n, relations, 2));
    }
}
