package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumCost {
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }
        distances[0][0] = grid[0][0];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0, 0));

        while (!queue.isEmpty()) {
            List<Integer> currentCell = queue.poll();
            int x = currentCell.get(0);
            int y = currentCell.get(1);

            if (x - 1 >= 0 && distances[x - 1][y] > distances[x][y] + grid[x - 1][y]) {
                distances[x - 1][y] = distances[x][y] + grid[x - 1][y];
                queue.add(Arrays.asList(x - 1, y));
            }
            if (x + 1 < n && distances[x + 1][y] > distances[x][y] + grid[x + 1][y]) {
                distances[x + 1][y] = distances[x][y] + grid[x + 1][y];
                queue.add(Arrays.asList(x + 1, y));
            }
            if (y - 1 >= 0 && distances[x][y - 1] > distances[x][y] + grid[x][y - 1]) {
                distances[x][y - 1] = distances[x][y] + grid[x][y - 1];
                queue.add(Arrays.asList(x, y - 1));
            }
            if (y + 1 < n && distances[x][y + 1] > distances[x][y] + grid[x][y + 1]) {
                distances[x][y + 1] = distances[x][y] + grid[x][y + 1];
                queue.add(Arrays.asList(x, y + 1));
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

        System.out.println(new MinimumCost().minimumCostPath(grid));  // 43
    }
}
