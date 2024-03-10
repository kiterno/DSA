package google.com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph{

    public int V;
    public ArrayList<Integer>[] adj;

    public Graph(int v) {
        V = v;
        this.adj = new ArrayList[V];

        for(int i=0;i<V;i++)
            adj[i] = new ArrayList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void bfs(int s){
        boolean vis[]=new boolean[V];

        Queue<Integer> queue=new LinkedList<>();

        vis[s] = true;
        queue.add(s);

        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s+" ");

            ArrayList<Integer> it = adj[s];
            for(int i: it){
                if(!vis[i]){
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
    }

    void dfs(int s){
        boolean vis[]=new boolean[V];
        dfsUtil(s, vis);
    }

    private void dfsUtil(int s, boolean[] vis) {
        vis[s] = true;
        System.out.print(s+" ");

        for(int i: adj[s]){
            if(!vis[i])
                dfsUtil(i, vis);
        }
    }
}