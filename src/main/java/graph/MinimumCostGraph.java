package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostGraph {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        boolean[] visited = new boolean[n * n];
        int[] costs = new int[n * n];
        int[] distances = new int[n * n];
        for (int i = 0; i < n * n; i++) distances[i] = Integer.MAX_VALUE;
        distances[0] = grid[0][0];
        List<List<Integer>> graph = new ArrayList<>(n * n);
        for (int i = 0; i < n * n; i++) graph.add(new ArrayList<>());
        PriorityQueue<Integer> queue = new PriorityQueue<>(n * n);
        queue.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int vertex = i * n + j;
                costs[vertex] = grid[i][j];

                if (i - 1 >= 0) graph.get(vertex).add(vertex - n);
                if (i + 1 < n) graph.get(vertex).add(vertex + n);
                if (j - 1 >= 0) graph.get(vertex).add(vertex - 1);
                if (j + 1 < n) graph.get(vertex).add(vertex + 1);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            if (!visited[vertex]) {
                visited[vertex] = true;

                for (int i : graph.get(vertex)) {
                    if (!visited[i]) {
                        if (distances[i] > distances[vertex] + costs[i]) {
                            distances[i] = distances[vertex] + costs[i];
                            queue.add(i);
                        }
                    }
                }
            }
        }

        return distances[n * n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}};

        System.out.println(new MinimumCostGraph().minimumCostPath(grid));  // 43
    }
}
