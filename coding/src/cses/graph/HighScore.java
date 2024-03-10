package cses.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighScore {
    static class Edge {
        int src, dest, weight;

        public Edge() {
            src = dest = weight = 0;
        }

        public void addEdge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int V, E;
    Edge edge[];

    public HighScore(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e+1];

        for (int i = 0; i <= e; i++) {
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        HighScore highScore = new HighScore(n, m);

        for (int i = 1; i <= m; i++) {
            String[] input2 = br.readLine().split(" ");
            int u = Integer.parseInt(input2[0]);
            int v = Integer.parseInt(input2[1]);
            int w = Integer.parseInt(input2[2]);

            highScore.edge[i].addEdge(u, v, w);
        }

        highScore.bellmanFord(highScore, 1);
    }

    private void bellmanFord(HighScore highScore, int src) {
        int V = highScore.V, E = highScore.E;

        int[] dist = new int[V+1];

        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MIN_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i <= V; ++i) {
            for (int j = 1; j <= E; ++j) {
                int u = highScore.edge[j].src;
                int v = highScore.edge[j].dest;
                int weight = highScore.edge[j].weight;
                if (dist[u] != Integer.MIN_VALUE
                        && dist[u] + weight > dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 1; j <= E; ++j) {
            int u = highScore.edge[j].src;
            int v = highScore.edge[j].dest;
            int weight = highScore.edge[j].weight;
            if (dist[u] != Integer.MIN_VALUE
                    && dist[u] + weight > dist[v]) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(dist[V]);
    }

    void printArr(int[] dist, int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i <= V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
