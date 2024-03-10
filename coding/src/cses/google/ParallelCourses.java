package cses.google;

import java.util.*;

public class ParallelCourses {
    public static int parallelCourses(int n, int[][] prerequisites) {
        // Write your code here

        List<Integer>[] adj= new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n+1];

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            inDegree[v] ++;
            adj[u].add(v);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] height = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                height[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int i: adj[node]) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    queue.add(i);
                    height[i] = height[node]+1;
                }
            }
        }

        if (count != n)
            return -1;
        else {
            int max = 0;
            for (int i = 0; i <= n; i++) {
                if (height[i]>max)
                    max = height[i];
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int t = sc.nextInt();

        while (t--> 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer>[] adj= new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            int[] inDegree = new int[n+1];

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                inDegree[v] ++;
                adj[u].add(v);
            }

            Queue<Integer> queue = new LinkedList<>();
            int[] height = new int[n+1];

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    height[i] = 1;
                }
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                count++;
                for (int i: adj[node]) {
                    inDegree[i]--;

                    if (inDegree[i] == 0) {
                        queue.add(i);
                        height[i] = height[node]+1;
                    }
                }
            }

            if (count != n)
                System.out.println("-1");
            else {
                int max = 0;
                for (int i = 0; i <= n; i++) {
                    if (height[i]>max)
                        max = height[i];
                }
                System.out.println(max);
            }
        }
    }
}
