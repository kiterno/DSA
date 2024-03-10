package leetcode.practice.dsu;

public class Dsu {
    int[] parent;
    int[] rank;
    int size;

    Dsu(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        size = n;

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x == parent[x]) return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    void unionByRank(int u, int v) {
        int ult_u = find(u);
        int ult_v = find(v);

        if (ult_u == ult_v) {
            return;
        }

        if (rank[ult_u] > rank[ult_v]){
            parent[ult_v] = ult_u;
        } else if (rank[ult_u] < rank[ult_v]) {
            parent[ult_u] = rank[ult_v];
        } else {
            parent[ult_v] = ult_u;
            rank[ult_u]++;
        }
    }
}
