package graph;

public class ShortestPath {
    public int shortestDistance(int m, int n, int a[][], int x, int y) {

    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int x = 2;
        int y = 3;
        int[][] a = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 1, 1}};

        System.out.println(new ShortestPath().shortestDistance(m, n, a, x, y));  // 5
    }
}
