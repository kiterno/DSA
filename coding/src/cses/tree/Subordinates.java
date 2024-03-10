//package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Subordinates {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] child = new int[n-1];

        for (int i = 0; i<n-1;i++) {
            child[i] = Integer.parseInt(input[i]);
        }
        StringBuilder resultReader = new StringBuilder();

        int[] result = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        createAdjacencyMap(n, child, adj);
//        System.out.println(adj);
        int x = getResultFromTree(adj, 1, result);
        for (int i = 0; i < n; i++) {
            resultReader.append(result[i]).append(" ");
        }
        System.out.println(resultReader);
    }

    private static int getResultFromTree(Map<Integer, List<Integer>> adj, int i, int[] result) {
        List<Integer> allElements = new ArrayList<>();
        if (!adj.containsKey(i)) {
            return 1;
        }
        else {
            List<Integer> list = adj.get(i);

            for (int it : list) {
                allElements.add(getResultFromTree(adj, it, result));
            }

            for (int it: allElements) {
                result[i-1] += it;
            }
        }

        return result[i-1]+1;
    }

    private static void createAdjacencyMap(int n, int[] child, Map<Integer, List<Integer>> adj) {
        for (int i = 0; i < child.length; i++) {
            List<Integer> list = adj.getOrDefault(child[i], new ArrayList<>());
            list.add(i+2);
            adj.put(child[i], list);
        }
    }
}
