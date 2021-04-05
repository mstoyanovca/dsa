package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int rows = 0;
    int columns = 0;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;

        Queue<Orange> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (grid[i][j] == 2)
                    queue.add(new Orange(i, j));
        queue.add(new Orange(-1, -1));

        while (!queue.isEmpty()) {
            boolean flag = false;
            while (!isDelimiter(queue.peek())) {
                Orange temp = queue.peek();

                // right cell
                if (isInGrid(temp.x + 1, temp.y) && grid[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        result++;
                        flag = true;
                    }
                    grid[temp.x + 1][temp.y] = 2;
                    temp.x++;
                    queue.add(new Orange(temp.x, temp.y));
                    temp.x--;
                }

                // left cell
                if (isInGrid(temp.x - 1, temp.y) && grid[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        result++;
                        flag = true;
                    }
                    grid[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    queue.add(new Orange(temp.x, temp.y));
                    temp.x++;
                }

                // top cell
                if (isInGrid(temp.x, temp.y + 1) && grid[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        result++;
                        flag = true;
                    }
                    grid[temp.x][temp.y + 1] = 2;
                    temp.y++;
                    queue.add(new Orange(temp.x, temp.y));
                    temp.y--;
                }

                // bottom cell
                if (isInGrid(temp.x, temp.y - 1) && grid[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        result++;
                        flag = true;
                    }
                    grid[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    queue.add(new Orange(temp.x, temp.y));
                }

                queue.remove();
            }

            queue.remove();
            if (!queue.isEmpty()) queue.add(new Orange(-1, -1));
        }

        return (checkAll(grid)) ? -1 : result;
    }

    private boolean isDelimiter(Orange orange) {
        return orange.x == -1 && orange.y == -1;
    }

    private boolean isInGrid(int i, int j) {
        return (i >= 0 && i < rows && j >= 0 && j < columns);
    }

    private boolean checkAll(int[][] arr) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                if (arr[i][j] == 1)
                    return true;

        return false;
    }

    private static class Orange {
        int x;
        int y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};

        System.out.println(new RottenOranges().orangesRotting(grid));  // 1
    }
}
