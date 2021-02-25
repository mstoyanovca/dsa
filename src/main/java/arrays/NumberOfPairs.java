package arrays;

import java.util.Arrays;

public class NumberOfPairs {
    public long countPairs(int[] x, int[] y, int m, int n) {
        if (m < 1 || m > 100_000) return 0;
        if (n < 1 || n > 100_000) return 0;
        for (int e : x) if (e < 1 || e > 1_000) return 0;
        for (int e : y) if (e < 1 || e > 1_000) return 0;

        final int[] exceptions = new int[4];
        for (int i = 0; i < n; i++) {
            if (y[i] > 0 && y[i] < 5) exceptions[y[i] - 1]++;
        }

        int counter = 0;
        Arrays.sort(y);

        for (int i = 0; i < m; i++) {
            counter += count(x[i], y, n, exceptions);
        }

        return counter;
    }

    private int count(int x, int[] y, int n, int[] exceptions) {
        if (x == 1) return 0;
        int index = nextGreaterElementIndex(x, y, n);
        int count = index >= 0 ? n - index : 0;

        count += exceptions[0];
        if (x == 2) count -= exceptions[2] + exceptions[3];
        if (x == 3) count += exceptions[1];

        return count;
    }

    private int nextGreaterElementIndex(int x, int[] y, int n) {
        if (x >= y[n - 1]) return -1;
        int index = Arrays.binarySearch(y, x);

        if (index >= 0) {
            while (index + 1 < n && y[index] <= y[index + 1]) index++;
        } else {
            index = -index - 1;
        }

        return index > n - 1 ? -1 : index;
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
