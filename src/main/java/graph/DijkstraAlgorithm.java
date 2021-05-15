package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraAlgorithm {
    public int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> graph, int source) {
        int[] distances = new int[v];
        for (int i = 0; i < v; i++) distances[i] = Integer.MAX_VALUE;
        distances[source] = 0;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            int minIndex = Arrays.stream(distances).min().orElse(-1);
            visited[minIndex] = true;
            for (ArrayList<Integer> adjacentVertex : graph.get(minIndex)) {  // (int vertex1, int distance1), (int vertex2, int distance2)
                int vertex = adjacentVertex.get(0);
                int distance = adjacentVertex.get(1);
                if (!visited[vertex] && distances[source] + distance < distances[vertex]) {
                    distances[vertex] = distances[source] + distance;
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int v = 3;
        int source = 2;
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 1)), new ArrayList<>(Arrays.asList(2, 6)))));  // 0
        graph.add(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(2, 3)))));  // 1
        graph.add(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(0, 6)), new ArrayList<>(Arrays.asList(1, 3)))));  // 2

        System.out.println(Arrays.toString(new DijkstraAlgorithm().dijkstra(v, graph, source)));  // 4 3 0
    }
}
