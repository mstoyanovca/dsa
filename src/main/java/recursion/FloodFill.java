package recursion;

import java.util.Arrays;

public class FloodFill {
    public int[][] floodFill(int[][] image, int row, int column, int newColor) {
        int oldColor = image[row][column];
        image[row][column] = newColor;

        if (row - 1 >= 0 && image[row - 1][column] == oldColor) {
            image[row - 1][column] = newColor;
            floodFill(image, row - 1, column, newColor);
        }
        if (row + 1 < image.length && image[row + 1][column] == oldColor) {
            image[row + 1][column] = newColor;
            floodFill(image, row + 1, column, newColor);
        }
        if (column - 1 >= 0 && image[row][column - 1] == oldColor) {
            image[row][column - 1] = newColor;
            floodFill(image, row, column - 1, newColor);
        }
        if (column + 1 < image[0].length && image[row][column + 1] == oldColor) {
            image[row][column + 1] = newColor;
            floodFill(image, row, column + 1, newColor);
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int row = 1;
        int column = 1;
        int newColor = 2;

        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, row, column, newColor)));
    }
}
