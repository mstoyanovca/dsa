package graph;

import java.util.*;

public class MinimumCostQueue {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        distances[0][0] = grid[0][0];
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(
                n * n,
                Comparator.comparingInt(cell -> distances[cell.get(0)][cell.get(1)]));
        ArrayList<Integer> startCell = new ArrayList<>(Arrays.asList(0, 0));
        queue.add(startCell);

        while (!queue.isEmpty()) {
            List<Integer> currentCell = queue.poll();
            int x = currentCell.get(0);
            int y = currentCell.get(1);

            if (visited[x][y]) continue;
            visited[x][y] = true;

            if (x - 1 >= 0 && !visited[x - 1][y]) {
                distances[x - 1][y] = Math.min(distances[x - 1][y], distances[x][y] + grid[x - 1][y]);
                queue.add(new ArrayList<>(Arrays.asList(x - 1, y)));
            }
            if (x + 1 < n && !visited[x + 1][y]) {
                distances[x + 1][y] = Math.min(distances[x + 1][y], distances[x][y] + grid[x + 1][y]);
                queue.add(new ArrayList<>(Arrays.asList(x + 1, y)));
            }
            if (y - 1 >= 0 && !visited[x][y - 1]) {
                distances[x][y - 1] = Math.min(distances[x][y - 1], distances[x][y] + grid[x][y - 1]);
                queue.add(new ArrayList<>(Arrays.asList(x, y - 1)));
            }
            if (y + 1 < n && !visited[x][y + 1]) {
                distances[x][y + 1] = Math.min(distances[x][y + 1], distances[x][y] + grid[x][y + 1]);
                queue.add(new ArrayList<>(Arrays.asList(x, y + 1)));
            }
        }

        return distances[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}};

        System.out.println(new MinimumCostQueue().minimumCostPath(grid));  // 43
    }
}
