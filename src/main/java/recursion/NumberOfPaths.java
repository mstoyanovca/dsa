package recursion;

public class NumberOfPaths {
    public long numberOfPaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println(new NumberOfPaths().numberOfPaths(m, n));  // 6
    }
}
