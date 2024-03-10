package cses.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildingRoads {
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dheer\\Downloads\\test_input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        adj = new List[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }



        while (m-->0) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n+1];
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                res.add(i);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    vis[x] = true;
                    for (int it: adj[x]) {
                        if (!vis[it]) {
                            queue.add(it);
                        }
                    }
                }
            }
        }

        int size = res.size();
        System.out.println(size-1);
        for (int i = 0; i < res.size()-1; i++) {
            System.out.println(res.get(i)+" " + res.get(i+1));
        }
    }
}
