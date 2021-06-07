package graph;

import java.util.Arrays;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        int vertices = matrix.length;
        int[][] distances = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distances[i][j] = matrix[i][j];
            }
        }

        for (int v = 0; v < vertices; v++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distances[i][v] + distances[v][j] < distances[i][j]) {
                        distances[i][j] = distances[i][v] + distances[v][j];
                    }
                }
            }
        }

        int x = 0;
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

        System.out.println(Arrays.toString(matrix1));  // {{0, 25}, {-1, 0}};
        System.out.println(Arrays.toString(matrix1));  // {{0,1,7},{1,0,6},{-1,-1,0}}
    }
}
