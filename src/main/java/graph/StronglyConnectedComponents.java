package graph;

import java.util.*;

public class StronglyConnectedComponents {
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> graph) {
        int result = 0;
        boolean[] visited = new boolean[v];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < v; i++) if (!visited[i]) loop(i, visited, stack, graph);

        for (int i = 0; i < v; i++) visited[i] = false;
        ArrayList<ArrayList<Integer>> transposed = transpose(v, graph);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!visited[i]) {
                loop2(i, visited, transposed);
                result++;
            }
        }

        return result;
    }

    private void loop(int vertex, boolean[] visited, Deque<Integer> stack, ArrayList<ArrayList<Integer>> graph) {
        visited[vertex] = true;
        for (int i : graph.get(vertex)) if (!visited[i]) loop(i, visited, stack, graph);
        stack.push(vertex);
    }

    private void loop2(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[vertex] = true;
        for (int i : graph.get(vertex)) if (!visited[i]) loop2(i, visited, graph);
    }

    private ArrayList<ArrayList<Integer>> transpose(int v, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> transposed = new ArrayList<>();
        for (int i = 0; i < v; i++) transposed.add(new ArrayList<>(Collections.emptyList()));
        for (int i = 0; i < v; i++) {
            List<Integer> adjacent = graph.get(i);
            for (int j : adjacent) transposed.get(j).add(i);
        }
        return transposed;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(2, 3)));           // 0
        graph.add(new ArrayList<>(Collections.singletonList(0)));  // 1
        graph.add(new ArrayList<>(Collections.singletonList(1)));  // 2
        graph.add(new ArrayList<>(Collections.singletonList(4)));  // 3
        graph.add(new ArrayList<>(Collections.emptyList()));       // 4

        System.out.println(new StronglyConnectedComponents().kosaraju(v, graph));  // 3
    }
}
