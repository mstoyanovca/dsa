package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpirallyTraversingMatrix {
    public ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        ArrayList<Integer> result = new ArrayList<>();

        while (isNotEmpty(matrix)) {
            result.addAll(printFirstRow(matrix));
            matrix = removeFirstRow(matrix);
            if (isNotEmpty(matrix)) {
                result.addAll(printLastColumn(matrix));
                matrix = removeLastColumn(matrix);
            }
            if (isNotEmpty(matrix)) {
                result.addAll(printLastRow(matrix));
                matrix = removeLastRow(matrix);
            }
            if (isNotEmpty(matrix)) {
                result.addAll(printFirstColumn(matrix));
                matrix = removeFirstColumn(matrix);
            }
        }

        return result;
    }

    private ArrayList<Integer> printFirstRow(int[][] matrix) {
        return Arrays
                .stream(matrix[0])
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Integer> printLastRow(int[][] matrix) {
        List<Integer> list = Arrays
                .stream(matrix[matrix.length - 1])
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(list);
        return new ArrayList<>(list);
    }

    private ArrayList<Integer> printFirstColumn(int[][] matrix) {
        List<Integer> list = Arrays.stream(matrix).map(row -> row[0]).collect(Collectors.toList());
        Collections.reverse(list);
        return new ArrayList<>(list);
    }

    private ArrayList<Integer> printLastColumn(int[][] matrix) {
        return Arrays.stream(matrix).map(row -> row[row.length - 1]).collect(Collectors.toCollection(ArrayList::new));
    }

    private int[][] removeFirstRow(int[][] matrix) {
        return Arrays.copyOfRange(matrix, 1, matrix.length);
    }

    private int[][] removeLastRow(int[][] matrix) {
        return Arrays.copyOfRange(matrix, 0, matrix.length - 1);
    }

    private int[][] removeFirstColumn(int[][] matrix) {
        return Arrays.stream(matrix).map(row -> Arrays.copyOfRange(row, 1, row.length)).toArray(int[][]::new);
    }

    private int[][] removeLastColumn(int[][] matrix) {
        return Arrays.stream(matrix).map(row -> Arrays.copyOfRange(row, 0, row.length - 1)).toArray(int[][]::new);
    }

    private boolean isNotEmpty(int[][] arr) {
        return arr.length > 0 && arr[0].length > 0;
    }

    public static void main(String[] args) {
        SpirallyTraversingMatrix spirallyTraversingMatrix = new SpirallyTraversingMatrix();

        int r = 4;
        int c = 4;
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        System.out.println(spirallyTraversingMatrix.spirallyTraverse(matrix, r, c));  // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    }
}
