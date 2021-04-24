package recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int row, int column, int newColor) {
        int previousColor = image[row][column];
        int[][] visited = new int[image.length][image[0].length];
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(row, column));
        visited[row][column] = 1;

        while (!queue.isEmpty()) {
            List<Integer> pixel = queue.remove();
            int r = pixel.get(0);
            int c = pixel.get(1);

            image[r][c] = newColor;

            if (r - 1 >= 0 && image[r - 1][c] == previousColor && visited[r - 1][c] == 0) {
                visited[r - 1][c] = 1;
                queue.add(Arrays.asList(r - 1, c));
            }
            if (r + 1 < image.length && image[r + 1][c] == previousColor && visited[r + 1][c] == 0) {
                visited[r + 1][c] = 1;
                queue.add(Arrays.asList(r + 1, c));
            }
            if (c - 1 >= 0 && image[r][c - 1] == previousColor && visited[r][c - 1] == 0) {
                visited[r][c - 1] = 1;
                queue.add(Arrays.asList(r, c - 1));
            }
            if (c + 1 < image[0].length && image[r][c + 1] == previousColor && visited[r][c + 1] == 0) {
                visited[r][c + 1] = 1;
                queue.add(Arrays.asList(r, c + 1));
            }
        }

        return image;
    }

    // recursive:
    private void loop(int[][] image, int row, int column, int previousColor, int newColor) {
        if (row < 0 || row > image.length - 1) return;
        if (column < 0 || column > image[0].length - 1) return;
        if (image[row][column] != previousColor) return;

        image[row][column] = newColor;

        // left:
        loop(image, row, column - 1, previousColor, newColor);
        // right:
        loop(image, row, column + 1, previousColor, newColor);
        // top:
        loop(image, row - 1, column, previousColor, newColor);
        // bottom:
        loop(image, row + 1, column, previousColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int row = 1;
        int column = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, row, column, newColor)));  // {{2,2,2},{2,2,0},{2,0,1}}
    }
}
