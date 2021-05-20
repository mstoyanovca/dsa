package graph;

public class ShortestPath {
    public int shortestDistance(int m, int n, int[][] a, int x, int y) {
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = 1_000;
            }
        }
        distances[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    if (i + 1 < m && a[i + 1][j] == 1 && distances[i][j] + 1 < distances[i + 1][j]) {
                        distances[i + 1][j] = distances[i][j] + 1;
                    }
                    if (i - 1 >= 0 && a[i - 1][j] == 1 && distances[i][j] + 1 < distances[i - 1][j]) {
                        distances[i - 1][j] = distances[i][j] + 1;
                    }
                    if (j + 1 < n && a[i][j + 1] == 1 && distances[i][j] + 1 < distances[i][j + 1]) {
                        distances[i][j + 1] = distances[i][j] + 1;
                    }
                    if (j - 1 >= 0 && a[i][j - 1] == 1 && distances[i][j] + 1 < distances[i][j - 1]) {
                        distances[i][j - 1] = distances[i][j] + 1;
                    }
                }
            }
        }

        return distances[x][y] < 1_000 ? distances[x][y] : -1;
    }

    public static void main(String[] args) {
        /*int m = 3;
        int n = 4;
        int x = 2;
        int y = 3;
        int[][] a = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 1, 1}};*/
        int m = 6;
        int n = 9;
        int x = 5;
        int y = 0;
        int[][] a = {{1, 1, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        System.out.println(new ShortestPath().shortestDistance(m, n, a, x, y));  // 5
    }
}
