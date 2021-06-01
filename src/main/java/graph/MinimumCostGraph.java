package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumCostGraph {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        List<List<Integer>> graph = new ArrayList<>(n * n);  // indexes
        for (int i = 0; i < n * n; i++) graph.add(new ArrayList<>());
        List<Integer> costs = new ArrayList<>(n * n);
        List<Integer> distances = new ArrayList<>(n * n);
        for (int i = 0; i < n * n; i++) distances.add(Integer.MAX_VALUE);
        distances.set(0, 0);
        Queue<Integer> queue = new LinkedList<>();  // indexes
        queue.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs.add(grid[i][j]);
                int vertex = i * n + j;

                if (i - 1 >= 0) graph.get(vertex).add(vertex - n);
                if (i + 1 < n) graph.get(vertex).add(vertex + n);
                if (j - 1 >= 0) graph.get(vertex).add(vertex - 1);
                if (j + 1 < n) graph.get(vertex).add(vertex + 1);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> adj = graph.get(vertex);

            for (int i : adj) {
                if (distances.get(i) > costs.get(vertex) + costs.get(i)) {
                    distances.set(i, costs.get(vertex) + costs.get(i));
                    queue.add(i);
                }
            }
        }

        return distances.get(n * n - 1);
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
