package cses.graph.disjointSetUnion;

public class DisjointSet {
    int[] rank, parent;
    int n;

    public DisjointSet(int n) {
        this.n = n;
        this.rank = new int[n+1];
        this.parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            this.parent[i] = i;
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent[node]) return node;

        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public void unionByRank(int u, int v) {
        int ult_u = findUltimateParent(u);
        int ult_v = findUltimateParent(v);

        if (ult_u == ult_v) return;

        if (rank[ult_u] < rank[ult_v]) {
            parent[ult_u] = ult_v;
        } else if (rank[ult_u] > rank[ult_v]) {
            parent[ult_v] = ult_u;
        } else {
            parent[ult_v] = ult_u;
            rank[ult_u]++;
        }
    }
}
