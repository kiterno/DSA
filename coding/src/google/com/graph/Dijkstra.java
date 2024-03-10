package google.com.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    /*

    {{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}}

     */

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> parentList1 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1); list1.add(1);
        list2.add(2);list2.add(6);
        parentList1.add(list1);parentList1.add(list2);


        ArrayList<ArrayList<Integer>> parentList2 = new ArrayList<>();
        ArrayList<Integer> list21 = new ArrayList<>();
        ArrayList<Integer> list22 = new ArrayList<>();
        list21.add(2);list21.add(3);
        list22.add(0);list22.add(1);
        parentList2.add(list21);parentList2.add(list22);

        ArrayList<ArrayList<Integer>> parentList3 = new ArrayList<>();
        ArrayList<Integer> list31 = new ArrayList<>();
        ArrayList<Integer> list32 = new ArrayList<>();
        list31.add(1);list31.add(3);
        list32.add(0);list32.add(6);
        parentList3.add(list31);parentList3.add(list32);

        adj.add(parentList1); adj.add(parentList2); adj.add(parentList3);

        for (int i: dijkstra(adj.size(), adj, 2)) {
            System.out.printf(i+"\t");
        }
        System.out.println();
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here

        boolean[] vis = new boolean[V];
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;

        for(int i=0;i<V-1;i++) {
            int u = minDistance(dist, vis);

            vis[u] = true;
            // u = 0
            for(ArrayList<Integer> v: adj.get(u)) {

                if(dist[v.get(0)] > dist[u] + v.get(1)) {
                    dist[v.get(0)] = dist[u] + v.get(1);
                }
            }
        }

        return dist;

    }

    private static int minDistance(int[] dist, boolean[] vis) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int i=0;i<dist.length;i++) {
            if(!vis[i] && dist[i]<=min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
