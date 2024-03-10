package cses.tree;

import java.io.*;
import java.util.*;

public class TreeMatching {
    static int root = -1;
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> adj = new HashMap<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File myObj = new File("test_input.txt");
        Scanner myReader = new Scanner(myObj);

        int n = Integer.parseInt( myReader.nextLine().trim());

        while (myReader.hasNextLine()) {
            String[] input = myReader.nextLine().split(" ");
            int x = Integer.parseInt(input[0].trim());
            int y = Integer.parseInt(input[1].trim());

            List<Integer> list = adj.getOrDefault(x, new ArrayList<>());
            list.add(y);
            adj.put(x, list);

            List<Integer> list1 = adj.getOrDefault(y, new ArrayList<>());
            list1.add(x);
            adj.put(y, list1);
        }

        System.out.println(adj);

        Set<Integer> edges = getEdgeNodes(adj);

        boolean[] vis = new boolean[n];
        boolean[] res = new boolean[n];

        getResultFromTree(adj, vis, res, root, -1, edges);

        int count = 0;
        for(boolean i: res) {
            count += i ? 1: 0;
        }

        System.out.println(count/2);
    }

    private static void getResultFromTree(Map<Integer, List<Integer>> adj, boolean[] vis, boolean[] res, int node, int parent, Set<Integer> edges) {
        vis[node-1] = true;
        if (root != node && edges.contains(node)) {
            if (parent != -1 && !res[parent - 1] && !res[node-1]) {
                res[parent-1] = true;
                res[node-1] = true;
            }
        } else if(adj.containsKey(node)) {
            for (int i: adj.get(node)) {
                if (!vis[i-1])
                    getResultFromTree(adj, vis, res, i, node, edges);
            }
            if (parent != -1 && !res[parent - 1] && !res[node-1]) {
                res[parent-1] = true;
                res[node-1] = true;
            }
        }
    }

    private static Set<Integer> getEdgeNodes(Map<Integer, List<Integer>> adj) {
        Set<Integer> edgeNodes = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                edgeNodes.add(entry.getKey());
                root = entry.getKey();
            }
        }

        return edgeNodes;
    }
}

