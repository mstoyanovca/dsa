package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DetectCycleUndirectedGraph {
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) if (!visited[i]) if (isCyclic(i, visited, graph, -1)) return true;
        return false;
    }

    private boolean isCyclic(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph, int parent) {
        visited[node] = true;
        for (int i : graph.get(node)) {
            if (!visited[i]) {
                if (isCyclic(i, visited, graph, node)) return true;
            } else if (visited[i] && i != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Collections.singletonList(1)));  // index 0
        graph.add(new ArrayList<>(Arrays.asList(0, 2, 4)));        // index 1
        graph.add(new ArrayList<>(Arrays.asList(1, 3)));           // index 2
        graph.add(new ArrayList<>(Arrays.asList(2, 4)));           // index 3
        graph.add(new ArrayList<>(Arrays.asList(1, 3)));           // index 4

        System.out.println(new DetectCycleUndirectedGraph().isCycle(5, graph));  // true
    }
}
