package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SourceToDestination {
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        int s = -1;
        int d = -1;
        boolean[] visited = new boolean[n * n];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n * n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int vertex = i * n + j;
                if (grid[i][j] != 0) {
                    if (j + 1 < n && grid[i][j + 1] != 0) graph.get(vertex).add(vertex + 1);
                    if (j - 1 >= 0 && grid[i][j - 1] != 0) graph.get(vertex).add(vertex - 1);
                    if (i + 1 < n && grid[i + 1][j] != 0) graph.get(vertex).add(vertex + n);
                    if (i - 1 >= 0 && grid[i - 1][j] != 0) graph.get(vertex).add(vertex - n);
                }
                if (grid[i][j] == 1) s = vertex;
                if (grid[i][j] == 2) d = vertex;
            }
        }

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int i : graph.get(vertex)) {
                if (vertex == d) return true;
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 3, 0, 0},
                {3, 0, 0, 0, 3},
                {3, 3, 3, 3, 3},
                {0, 2, 3, 0, 0},
                {3, 0, 0, 1, 3}};

        System.out.println(new SourceToDestination().is_Possible(grid));  // false
    }
}
