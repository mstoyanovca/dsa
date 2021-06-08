package graph;

import java.util.Arrays;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        int vertices = matrix.length;

        for (int v = 0; v < vertices; v++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (matrix[i][j] == -1) matrix[i][j] = 1_000;
                    if (matrix[i][v] == -1) matrix[i][v] = 1_000;
                    if (matrix[v][j] == -1) matrix[v][j] = 1_000;

                    if (matrix[i][j] > matrix[i][v] + matrix[v][j]) matrix[i][j] = matrix[i][v] + matrix[v][j];

                    if (matrix[i][j] == 1_000) matrix[i][j] = -1;
                    if (matrix[i][v] == 1_000) matrix[i][v] = -1;
                    if (matrix[v][j] == 1_000) matrix[v][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 25},
                {-1, 0}};
        int[][] matrix2 = {
                {0, 1, 43},
                {1, 0, 6},
                {-1, -1, 0}};

        new FloydWarshall().shortest_distance(matrix1);
        new FloydWarshall().shortest_distance(matrix2);

        System.out.println(Arrays.deepToString(matrix1));  // {{0, 25}, {-1, 0}};
        System.out.println(Arrays.deepToString(matrix2));  // {{0,1,7},{1,0,6},{-1,-1,0}}
    }
}
