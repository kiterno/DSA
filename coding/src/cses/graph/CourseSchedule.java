package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        adj = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];
        while (m-->0) {
            String[] strings = br.readLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            adj[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                arr.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for(int neighbour: adj[node]) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                    arr.add(neighbour);
                }
            }
        }

        if (arr.size() == n) {
            for(int i: arr)
                System.out.print(i+" ");
            System.out.println( );
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}