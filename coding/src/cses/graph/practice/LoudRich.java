package cses.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudRich {
    List<Integer>[] adj;
    int[] answer;
    int[] quite;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        adj = new List[n];
        answer = new int[n];
        this.quite = quiet;
        for (int i=0;i<n;i++)
            adj[i] = new ArrayList<>();

        for (int[] rich: richer) {
            adj[rich[1]].add(rich[0]);
        }

        Arrays.fill(answer, -1);
        for (int node=0; node<n; node++) {
            dfs(node);
        }
        return answer;
    }

    private int dfs(int node) {
        if (answer[node] == -1) {
            answer[node] = node;

            for (int child: adj[node]) {
                int cand = dfs(child);

                if (quite[cand] < quite[answer[node]]) {
                    answer[node] = cand;
                }
            }
        }

        return answer[node];
    }
}
