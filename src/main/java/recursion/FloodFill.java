package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int row, int column, int newColor) {
        int previousColor = image[row][column];
        int[][] visited = new int[image[0].length][image.length];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(row, column));
        visited[row][column] = 1;

        while (!queue.isEmpty()) {
            List<Integer> tuple = queue.remove();
            int x = tuple.get(0);
            int y = tuple.get(1);

            image[x][y] = newColor;

            if (x - 1 >= 0 && image[x - 1][y] == previousColor && visited[x - 1][y] == 0) {
                visited[x - 1][y] = 1;
                queue.add(Arrays.asList(x - 1, y));
            }
            if (x + 1 < image[0].length && image[x + 1][y] == previousColor && visited[x + 1][y] == 0) {
                visited[x + 1][y] = 1;
                queue.add(Arrays.asList(x + 1, y));
            }
            if (y - 1 >= 0 && image[x][y - 1] == previousColor && visited[x][y - 1] == 0) {
                visited[x][y - 1] = 1;
                queue.add(Arrays.asList(x, y - 1));
            }
            if (y + 1 < image.length && image[x][y + 1] == previousColor && visited[x][y + 1] == 0) {
                visited[x][y + 1] = 1;
                queue.add(Arrays.asList(x, y + 1));
            }
        }

        return image;
    }

    // recursive:
    private void loop(int[][] image, int row, int column, int oldColor, int newColor) {
        if (row < 0 || row > image.length - 1) return;
        if (column < 0 || column > image[0].length - 1) return;
        if (image[row][column] != oldColor) return;

        image[row][column] = newColor;

        // left:
        loop(image, row, column - 1, oldColor, newColor);
        // right:
        loop(image, row, column + 1, oldColor, newColor);
        // top:
        loop(image, row - 1, column, oldColor, newColor);
        // bottom:
        loop(image, row + 1, column, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int row = 1;
        int column = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, row, column, newColor)));
    }
}
