package graph;

import java.util.ArrayList;
import java.util.Collections;

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[v];
        boolean[] beingVisited = new boolean[v];

        for (int i = 0; i < v; i++)
            if (!visited[i] && loop(i, visited, beingVisited, graph))
                return true;

        return false;
    }

    private boolean loop(int node, boolean[] visited, boolean[] beingVisited, ArrayList<ArrayList<Integer>> graph) {
        beingVisited[node] = true;

        for (int i : graph.get(node)) {
            if (beingVisited[i]) {
                return true;
            } else if (!visited[i] && loop(i, visited, beingVisited, graph)) {
                return true;
            }
        }

        beingVisited[node] = false;
        visited[node] = true;

        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Collections.emptyList()));       // 0
        graph.add(new ArrayList<>(Collections.singletonList(2)));  // 1
        graph.add(new ArrayList<>(Collections.singletonList(4)));  // 2
        graph.add(new ArrayList<>(Collections.singletonList(1)));  // 3
        graph.add(new ArrayList<>(Collections.singletonList(0)));  // 4
        graph.add(new ArrayList<>(Collections.singletonList(3)));  // 5
        graph.add(new ArrayList<>(Collections.singletonList(5)));  // 6

        System.out.println(new DetectCycleDirectedGraph().isCyclic(v, graph));  // false
    }
}
