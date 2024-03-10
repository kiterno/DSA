package google.com.graph;

public class BFS {
    public static void main(String[] args) {
        Graph graph=new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.bfs(2);
        System.out.println();
        graph.dfs(2);
    }
}