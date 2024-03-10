package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDiameter {
    static int diameter = 0;
    public static void main(String[] args) throws IOException {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i< n; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0].trim());
            int v = Integer.parseInt(input[1].trim());

            List<Integer> list1 = tree.getOrDefault(u, new ArrayList<>());
            list1.add(v);
            tree.put(u, list1);

            List<Integer> list2 = tree.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            tree.put(v, list2);
        }

        boolean[] vis = new boolean[n];

        int x = getDiameter(tree, 1, vis);
        System.out.println(diameter);
    }

    private static int getDiameter(Map<Integer, List<Integer>> tree, int root, boolean[] vis) {
        vis[root-1] = true;

        List<Integer> childrens = new ArrayList<>();
        for (int nodes: tree.get(root)) {
            if (!vis[nodes-1])
                childrens.add(getDiameter(tree, nodes, vis));
        }

        if (childrens.isEmpty()) {
            return 1;
        }
        childrens.sort(Collections.reverseOrder());
//        System.out.println(childrens);
        if (childrens.size()>=2)
            diameter = Math.max(childrens.get(0)+childrens.get(1), diameter);
        else
            diameter = Math.max(childrens.get(0), diameter);

        return childrens.get(0) + 1;
    }
}
