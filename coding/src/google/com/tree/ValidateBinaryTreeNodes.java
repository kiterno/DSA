package google.com.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        Set<Integer> set = new HashSet<>();
        int root = findRoot(set, n, leftChild, rightChild);

        if (root == -1) return false;
        Set<Integer> vis = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == -1) continue;
            if (!vis.add(node)) return false;

            int left = leftChild[node];
            int right = rightChild[node];
            queue.add(left);
            queue.add(right);
        }

        return vis.size() == n;
    }

    private int findRoot(Set<Integer> set, int n, int[] leftChild, int[] rightChild) {
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int i: leftChild) set.remove(i);
        for (int i: rightChild) set.remove(i);

        return set.size() == 1 ? set.iterator().next() : -1;
    }

}
