package cses.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDistancesII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int i = 0; i< n-1;i++) {
            String[] inputs = br.readLine().split(" ");
            int u = Integer.parseInt(inputs[0]);
            int v = Integer.parseInt(inputs[1]);

            List<Integer> list1 = tree.getOrDefault(u, new ArrayList<>());
            list1.add(v);
            tree.put(u, list1);

            List<Integer> list2 = tree.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            tree.put(v, list2);
        }

        boolean[] vis = new boolean[n+1];
        int[] child = new int[n+1];
        int[] parent = new int[n+1];

        int root = 1, depth = 0;
        int sum = getSum(tree, child, parent, depth, root, -1);
        int[] res = new int[n];
        res[root-1] = sum;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            vis[x] = true;
            for (int u: tree.get(x)) {
                if(!vis[u])
                    queue.add(u);
            }
            if (parent[x] != -1) {
                res[x - 1] = res[parent[x]-1] - child[x] + n - child[x] - 2;
            }
        }
        print(res);
    }



    private static int getSum(Map<Integer, List<Integer>> tree, int[] child, int[] parent, int depth, int root, int father) {
        parent[root] = father;
        if (tree.get(root).size() == 1 && father != -1) {
            child[root] = 0;
            return depth;
        }
        int sum = depth;

        for (int v: tree.get(root)) {
            if (v != father) {
                sum += getSum(tree, child, parent, depth+1, v, root);
                child[root] += child[v]+1;
            }
        }

        return sum;
    }

    private static void print(int[] child) {
        for (int i = 0; i < child.length; i++) {
            System.out.print(child[i]+" ");
        }
        System.out.println();
    }
}
