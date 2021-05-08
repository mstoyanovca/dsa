package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int removed = queue.remove();
            result.add(removed);
            for (int i : adj.get(removed)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

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
        int v = 10;
        Graph graph = new Graph(10);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(1, 7);
        graph.addEdge(1, 8);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(2, 8);
        graph.addEdge(2, 9);
        graph.addEdge(3, 4);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(3, 9);
        graph.addEdge(4, 5);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(6, 8);
        graph.addEdge(8, 9);

        System.out.println(new BFS().bfsOfGraph(v, graph.graph));  // 0 2 3 4 5 6 7 8 9
    }
}
