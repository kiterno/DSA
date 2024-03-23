package google.com.graph.dsu;

public class DisjointSetUnion {
    int[] rank, parent;
    int n;

    DisjointSetUnion(int n) {
        this.n = n;
        rank = new int[n+1];
        parent = new int[n+1];

        for (int i=0;i<=n;i++) {
            parent[i] = i;
        }
    }


    int findUltimateParent(int node) {
        if (node == parent[node]) return node;

        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    void unionByRank(int u, int v) {
        int ult_u = findUltimateParent(u);
        int ult_v = findUltimateParent(v);

        if (ult_v == ult_u) return;

        if (rank[ult_u] > rank[ult_v]) {
            parent[ult_v] = ult_u;
        } else if (rank[ult_u] < rank[ult_v]) {
            parent[ult_u] = ult_v;
        } else {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(edges.length);

        for (int[] edge: edges) {
            int ult_u = disjointSetUnion.findUltimateParent(edge[0]);
            int ult_v = disjointSetUnion.findUltimateParent(edge[1]);

            if (ult_v == ult_u) return edge;

            disjointSetUnion.unionByRank(edge[0], edge[1]);
        }

        return new int[0];
    }
}
