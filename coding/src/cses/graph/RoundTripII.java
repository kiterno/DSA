package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RoundTripII {
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);
            adj[u].add(v);
        }

        List<Integer> cycle = roundTrip(n, adj);

        if (cycle.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cycle.size());
            for(int i: cycle)
                System.out.print(i+" ");
            System.out.println();
        }
    }

    private static List<Integer> roundTrip(int n, List<Integer>[] adj) {
        boolean[] vis = new boolean[n+1];
        boolean[] recStack = new boolean[n+1];

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i] ) {
                if (isCycle(i, vis, recStack, stack, adj)) {
                    return extract(stack);
                }
            }
        }

        return new ArrayList<>();
    }

    private static boolean isCycle(int node, boolean[] vis, boolean[] recStack, Stack<Integer> stack, List<Integer>[] adj) {
        vis[node] = recStack[node] = true;

        stack.push(node);

        for(int neighbour: adj[node]) {
            if (!vis[neighbour]) {
                if (isCycle(neighbour, vis, recStack, stack, adj)) {
                    return true;
                }
            } else if (recStack[neighbour]) {
                stack.push(neighbour);
                return true;
            }
        }

        recStack[node] = false;
        stack.pop();
        return false;
    }

    private static List<Integer> extract(Stack<Integer> stack) {
        List<Integer> arr = new ArrayList<>();
        int node = stack.pop();
        arr.add(node);
        while (!stack.isEmpty()) {
            arr.add(stack.peek());

            if (stack.peek() == node) {
                break;
            }
            stack.pop();
        }

        Collections.reverse(arr);
        return arr;
    }
}
