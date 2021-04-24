package recursion;

import java.util.Arrays;

public class FloodFill {
    public int[][] floodFill(int[][] image, int row, int column, int newColor) {
        loop(image, row, column, image[row][column], newColor);
        return image;
    }

    private void loop(int[][] image, int row, int column, int oldColor, int newColor) {
        if (row < 0 || row > image.length - 1) return;
        if (column < 0 || column > image[0].length - 1) return;
        if (image[row][column] != oldColor) return;

        image[row][column] = newColor;

        loop(image, row, column - 1, oldColor, newColor);
        loop(image, row, column + 1, oldColor, newColor);
        loop(image, row - 1, column, oldColor, newColor);
        loop(image, row + 1, column, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int row = 1;
        int column = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, row, column, newColor)));
    }
}
