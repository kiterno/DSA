package cses.graph.disjointSetUnion;


class Solution {
    public int minSwapsCouples(int[] row) {
        CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands(row.length);
        int n = row.length/2;
        for (int i = 0; i<row.length; i += 2) {
            couplesHoldingHands.union(row[i]/2, row[i + 1]/2);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i == couplesHoldingHands.findUltimateParent(couplesHoldingHands.parent[i])) {
                count++;
            }
        }

        return n - count;
    }
    public static class CouplesHoldingHands {

        int[] parent;
        int n;

        public CouplesHoldingHands(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int findUltimateParent(int node) {
            if (node != parent[node])
                parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        void union(int u, int v) {
            int ult_u = findUltimateParent(u);
            int ult_v = findUltimateParent(v);

            if (ult_v != ult_u)
                parent[u] = v;
        }
    }
}
