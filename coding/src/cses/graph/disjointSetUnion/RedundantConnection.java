package cses.graph.disjointSetUnion;

import java.util.Arrays;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        int ans1 = -1;
        int ans2 = -1;
        int [] inDegree = new int[edges.length+1];
        Arrays.fill(inDegree,-1);

        for( int i = 0 ; i < edges.length; i++ ){
            int var1 = edges[i][0];
            int var2 = edges[i][1];
            if( inDegree[var2] == -1 ) inDegree[var2] = i;
            else {
                ans1 = inDegree[var2];
                ans2 = i;    //store the double parent
            }
        }

        for(int[] edge: edges) {
            int ult_u = disjointSet.findUltimateParent(edge[0]);
            int ult_v = disjointSet.findUltimateParent(edge[1]);

            if (ult_v == ult_u) return ans1 == -1? edge : edges[ans1];

            disjointSet.unionByRank(edge[0], edge[1]);
        }

        return edges[ans2];
    }
}