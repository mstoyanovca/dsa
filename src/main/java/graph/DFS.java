package graph;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        return loop(v, new boolean[adj.size()], adj, new ArrayList<>());
    }

    private ArrayList<Integer> loop(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> result) {
        result.add(node);
        visited[node] = true;

        ArrayList<Integer> sublist = graph.get(node);
        for (int i : sublist) if (!visited[i]) loop(i, visited, graph, result);

        return result;
    }

    private static class Graph {
        private int nodes;
        private ArrayList<ArrayList<Integer>> graph;

        public Graph(int nodes) {
            this.nodes = nodes;
            graph = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                ArrayList<Integer> sublist = new ArrayList<>();
                graph.add(sublist);
            }
        }

        public void addEdge(int node, int toNode) {
            graph.get(node).add(toNode);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(4, 3);

        System.out.println(new DFS().dfsOfGraph(0, graph.graph));  //  0 1 2 4 3
    }
}
