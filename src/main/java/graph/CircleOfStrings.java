package graph;

import java.util.ArrayList;
import java.util.List;

public class CircleOfStrings {
    private static final int CHARS = 26;
    private final List<List<Integer>> graph;
    private final int[] inDegree;

    public CircleOfStrings() {
        graph = new ArrayList<>(CHARS);
        for (int i = 0; i < CHARS; i++) graph.add(new ArrayList<>());
        inDegree = new int[CHARS];
    }

    public int isCircle(int vertices, String[] arr) {
        for (int i = 0; i < vertices; i++) {
            String s = arr[i];
            int first = s.charAt(0) - 'a';
            int last = s.charAt(s.length() - 1) - 'a';
            graph.get(first).add(last);
            inDegree[last]++;
        }

        return hasEulerianCircuit() ? 1 : 0;
    }

    private boolean hasEulerianCircuit() {
        if (!isStronglyConnected()) return false;
        for (int i = 0; i < CHARS; i++) if (graph.get(i).size() != inDegree[i]) return false;
        return true;
    }

    private boolean isStronglyConnected() {
        // the first vertex with non-zero degree:
        int start = -1;
        for (int i = 0; i < CHARS; i++) {
            if (graph.get(i).size() > 0) {
                start = i;
                break;
            }
        }
        boolean[] visited = new boolean[CHARS];

        dfs(start, visited, graph);
        for (int i = 0; i < CHARS; i++) if (graph.get(i).size() > 0 && !visited[i]) return false;

        for (int i = 0; i < CHARS; i++) visited[i] = false;
        dfs(start, visited, transpose());
        for (int i = 0; i < CHARS; i++) if (graph.get(i).size() > 0 && !visited[i]) return false;

        return true;
    }

    private void dfs(int start, boolean[] visited, List<List<Integer>> graph) {
        visited[start] = true;
        for (int i : graph.get(start)) if (!visited[i]) dfs(i, visited, graph);
    }

    private List<List<Integer>> transpose() {
        List<List<Integer>> reverseGraph = new ArrayList<>(CHARS);
        for (int i = 0; i < CHARS; i++) reverseGraph.add(new ArrayList<>());
        for (int i = 0; i < CHARS; i++) for (int j : graph.get(i)) reverseGraph.get(j).add(i);
        return reverseGraph;
    }

    public static void main(String[] args) {
        String[] a = {"abc", "bcd", "cdf"};
        String[] b = {"ab", "bc", "cd", "da"};

        System.out.println(new CircleOfStrings().isCircle(3, a));  // 0
        System.out.println(new CircleOfStrings().isCircle(4, b));  // 1
    }
}
