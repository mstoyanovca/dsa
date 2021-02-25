package arrays;

import java.util.Arrays;

public class NumberOfPairs {
    public long countPairs(int[] x, int[] y, int m, int n) {
        if (m < 1 || m > 100_000) return 0;
        if (n < 1 || n > 100_000) return 0;
        if (Arrays.stream(x).anyMatch(e -> e < 1 || e > 1_000)) return 0;
        if (Arrays.stream(y).anyMatch(e -> e < 1 || e > 1_000)) return 0;

        final int[] exceptions = new int[5];
        for (int i = 0; i < n; i++) if (y[i] < 5) exceptions[y[i]]++;

        Arrays.sort(y);

        int counter = 0;
        for (int i = 0; i < m; i++) counter += count(x[i], y, n, exceptions);
        return counter;
    }

    private int count(int x, int[] y, int n, int[] exceptions) {
        if (x == 0) return 0;
        if (x == 1) return exceptions[0];
        int count = n - ngeIndex(x, y, n);

        count += exceptions[0] + exceptions[1];
        if (x == 2) count -= exceptions[3] + exceptions[4];
        if (x == 3) count += exceptions[2];

        return count;
    }

    private int ngeIndex(int x, int[] y, int n) {
        if (x >= y[n - 1]) return n;
        int index = Arrays.binarySearch(y, x);

        if (index >= 0) {
            while (x == y[index]) index++;
        } else {
            index = -index - 1;
        }

        return index;
    }

    public static void main(String[] args) {
        NumberOfPairs numberOfPairs = new NumberOfPairs();

        int m = 3;
        int n = 2;
        int[] x = {2, 1, 6};
        int[] y = {1, 5};

        System.out.println(numberOfPairs.countPairs(x, y, m, n));  // 3
    }
}
