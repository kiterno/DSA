package cses.graph.kruskals;

import cses.graph.disjointSetUnion.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumSpanningTree {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args)
    {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<Edge>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));

        // Sort the edges in non-decreasing order
        // (increasing with repetition allowed)
        graphEdges.sort(new Comparator<Edge>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });

        kruskals(V, graphEdges);
    }

    private static void kruskals(int v, List<Edge> graphEdges) {
        DisjointSet disjointSet = new DisjointSet(v);
        List<Edge> result = new ArrayList<>();

        for (Edge e: graphEdges) {
            int ult_u = disjointSet.findUltimateParent(e.src);
            int ult_v = disjointSet.findUltimateParent(e.dest);

            if (ult_u != ult_v) {
                result.add(e);
                disjointSet.unionByRank(e.src, e.dest);
            }
        }

        for(Edge e: result) {
            System.out.println(e.src+" --- "+e.dest+" ---> "+e.weight);
        }
    }
}
