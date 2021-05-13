package graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;

        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (!visited[row][column] && grid[row][column] == 1) {
                    loop(row, column, visited, grid);
                    result++;
                }

        return result;
    }

    private void loop(int row, int column, boolean[][] visited, char[][] grid) {
        visited[row][column] = true;

        if (row - 1 >= 0 && !visited[row - 1][column] && grid[row - 1][column] == 1)
            loop(row - 1, column, visited, grid);
        if (row + 1 < grid.length && !visited[row + 1][column] && grid[row + 1][column] == 1)
            loop(row + 1, column, visited, grid);
        if (column - 1 >= 0 && !visited[row][column - 1] && grid[row][column - 1] == 1)
            loop(row, column - 1, visited, grid);
        if (column + 1 < grid[0].length && !visited[row][column + 1] && grid[row][column + 1] == 1)
            loop(row, column + 1, visited, grid);
        if (row - 1 >= 0 && column - 1 >= 0 && !visited[row - 1][column - 1] && grid[row - 1][column - 1] == 1)
            loop(row - 1, column - 1, visited, grid);
        if (row - 1 >= 0 && column + 1 < grid[0].length && !visited[row - 1][column + 1] && grid[row - 1][column + 1] == 1)
            loop(row - 1, column + 1, visited, grid);
        if (row + 1 < grid.length && column - 1 >= 0 && !visited[row + 1][column - 1] && grid[row + 1][column - 1] == 1)
            loop(row + 1, column - 1, visited, grid);
        if (row + 1 < grid.length && column + 1 < grid[0].length && !visited[row + 1][column + 1] && grid[row + 1][column + 1] == 1)
            loop(row + 1, column + 1, visited, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {{0, 1}, {1, 0}, {1, 1}, {1, 0}};

        System.out.println(new NumberOfIslands().numIslands(grid));  // 1
    }
}
