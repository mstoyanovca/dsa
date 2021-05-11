package graph;

import java.util.*;

public class TopologicalSort {
    public int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) loop(i, visited, stack, adj);
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private void loop(int v, boolean[] visited, Deque<Integer> stack, ArrayList<ArrayList<Integer>> graph) {
        visited[v] = true;
        for (int i : graph.get(v)) if (!visited[i]) loop(i, visited, stack, graph);
        stack.push(v);
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Collections.emptyList()));       // 0
        graph.add(new ArrayList<>(Collections.singletonList(0)));  // 1
        graph.add(new ArrayList<>(Collections.singletonList(0)));  // 2
        graph.add(new ArrayList<>(Collections.singletonList(0)));  // 3

        System.out.println(Arrays.toString(new TopologicalSort().topoSort(n, graph)));  // 3, 2, 1, 0
    }
}
