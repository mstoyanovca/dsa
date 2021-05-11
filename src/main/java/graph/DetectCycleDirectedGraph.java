package graph;

import java.util.ArrayList;
import java.util.Collections;

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) if (loop(0, visited, stack, graph)) {
                return true;
            }
        }
        return false;
    }

    private boolean loop(int node, boolean[] visited, boolean[] stack, ArrayList<ArrayList<Integer>> graph) {
        if (stack[node]) return true;
        if (visited[node]) return false;
        visited[node] = true;
        stack[node] = true;

        for (int i : graph.get(node)) {
            if (loop(i, visited, stack, graph)) return true;
        }
        stack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Collections.singletonList(1)));  // 0
        graph.add(new ArrayList<>(Collections.singletonList(2)));  // 1
        graph.add(new ArrayList<>(Collections.singletonList(3)));  // 2
        graph.add(new ArrayList<>(Collections.singletonList(3)));  // 3

        System.out.println(new DetectCycleDirectedGraph().isCyclic(v, graph));  // true
    }
}
