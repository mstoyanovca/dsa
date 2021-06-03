package graph;

import java.util.ArrayList;
import java.util.List;

public class CircleOfStrings {
    private static final int CHARS = 26;
    private final int[] inDegree = new int[CHARS];

    public int isCircle(int vertices, String[] arr) {
        List<List<Integer>> graph = new ArrayList<>(CHARS);
        for (int i = 0; i < CHARS; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < vertices; i++) {
            String s = arr[i];
            int first = s.charAt(0) - 'a';
            int last = s.charAt(s.length() - 1) - 'a';
            graph.get(first).add(last);
            inDegree[last]++;
        }

        return hasEulerianCircuit(vertices, graph) ? 1 : 0;
    }

    private boolean hasEulerianCircuit(int vertices, List<List<Integer>> graph) {
        if (!isStronglyConnected(vertices, graph)) return false;
        for (int i = 0; i < vertices; i++) if (graph.get(i).size() != inDegree[i]) return false;
        return true;
    }

    private boolean isStronglyConnected(int vertices, List<List<Integer>> graph) {
        boolean[] visited = new boolean[vertices];
        dfs(0, visited, graph);
        for (int i = 0; i < vertices; i++) if (!visited[i]) return false;

        for (int i = 0; i < vertices; i++) visited[i] = false;
        List<List<Integer>> reverseGraph = transpose(vertices, graph);
        dfs(0, visited, reverseGraph);
        for (int i = 0; i < vertices; i++) if (!visited[i]) return false;

        return true;
    }

    private void dfs(int start, boolean[] visited, List<List<Integer>> graph) {
        visited[start] = true;
        for (int i : graph.get(start))
            if (!visited[i])
                dfs(i, visited, graph);
    }

    private List<List<Integer>> transpose(int vertices, List<List<Integer>> graph) {
        List<List<Integer>> reverseGraph = new ArrayList<>(CHARS);
        for (int i = 0; i < CHARS; i++) reverseGraph.add(new ArrayList<>());
        for (int i = 0; i < vertices; i++) {
            for (int j : graph.get(i)) {
                reverseGraph.get(j).add(i);
                inDegree[i]++;
            }
        }
        return reverseGraph;
    }

    public static void main(String[] args) {
        String[] a = {"abc", "bcd", "cdf"};
        String[] b = {"ab", "bc", "cd", "da"};

        System.out.println(new CircleOfStrings().isCircle(3, a));  // false
        System.out.println(new CircleOfStrings().isCircle(4, b));  // true
    }
}
