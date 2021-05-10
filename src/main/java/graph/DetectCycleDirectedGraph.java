package graph;

import java.util.ArrayList;
import java.util.Collections;

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (loop(0, visited, graph, -1)) return true;
        }
        return false;
    }

    private boolean loop(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int parent) {
        visited[node] = true;
        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (loop(i, visited, graph, node)) return true;
            } else if (visited[i] && i != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Collections.singletonList(1)));
        graph.add(new ArrayList<>(Collections.singletonList(2)));
        graph.add(new ArrayList<>(Collections.singletonList(3)));
        graph.add(new ArrayList<>(Collections.singletonList(3)));

        System.out.println(new DetectCycleDirectedGraph().isCyclic(v, graph));
    }
}
