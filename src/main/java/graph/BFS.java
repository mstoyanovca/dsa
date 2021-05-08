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

        while (!queue.isEmpty()) {
            int removed = queue.remove();
            visited[removed] = true;
            result.add(removed);
            for (int i : adj.get(removed)) {
                if (!visited[i]) {
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
        int v = 5;
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);

        System.out.println(new BFS().bfsOfGraph(v, graph.graph));  // 0 1 2 3 4
    }
}
