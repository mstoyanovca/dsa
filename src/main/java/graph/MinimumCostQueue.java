package graph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostQueue {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) distances[i][j] = Integer.MAX_VALUE;
        distances[0][0] = grid[0][0];
        PriorityQueue<Cell> queue = new PriorityQueue<>(n * n, Comparator.comparingInt(Cell::getDistance));
        queue.add(new Cell(0, 0, grid[0][0]));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int x = cell.x;
            int y = cell.y;

            if (x - 1 >= 0 && distances[x - 1][y] > distances[x][y] + grid[x - 1][y]) {
                distances[x - 1][y] = distances[x][y] + grid[x - 1][y];
                queue.add(new Cell(x - 1, y, distances[x - 1][y]));
            }
            if (x + 1 < n && distances[x + 1][y] > distances[x][y] + grid[x + 1][y]) {
                distances[x + 1][y] = distances[x][y] + grid[x + 1][y];
                queue.add(new Cell(x + 1, y, distances[x + 1][y]));
            }
            if (y - 1 >= 0 && distances[x][y - 1] > distances[x][y] + grid[x][y - 1]) {
                distances[x][y - 1] = distances[x][y] + grid[x][y - 1];
                queue.add(new Cell(x, y - 1, distances[x][y - 1]));
            }
            if (y + 1 < n && distances[x][y + 1] > distances[x][y] + grid[x][y + 1]) {
                distances[x][y + 1] = distances[x][y] + grid[x][y + 1];
                queue.add(new Cell(x, y + 1, distances[x][y + 1]));
            }
        }

        return distances[n - 1][n - 1];
    }

    private static class Cell {
        int x;
        int y;
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
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
