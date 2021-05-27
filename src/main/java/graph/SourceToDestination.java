package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SourceToDestination {
    public boolean is_Possible(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<Vertex> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Vertex(i, j));
                    break;
                }
            }
        }

        while (queue.size() > 0) {
            Vertex vertex = queue.poll();
            int row = vertex.row;
            int column = vertex.column;

            if (grid[row][column] == 2) return true;
            grid[row][column] = 0;

            if (row - 1 >= 0 && grid[row - 1][column] != 0) {
                queue.add(new Vertex(row - 1, column));
            }
            if (row + 1 <= rows - 1 && grid[row + 1][column] != 0) {
                queue.add(new Vertex(row + 1, column));
            }
            if (column - 1 >= 0 && grid[row][column - 1] != 0) {
                queue.add(new Vertex(row, column - 1));
            }
            if (column + 1 <= columns - 1 && grid[row][column + 1] != 0) {
                queue.add(new Vertex(row, column + 1));
            }
        }

        return false;
    }

    private static class Vertex {
        private final int row;
        private final int column;

        public Vertex(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
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
