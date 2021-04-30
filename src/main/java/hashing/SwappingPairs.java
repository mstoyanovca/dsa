package hashing;

import java.util.Arrays;

public class SwappingPairs {
    public long findSwapValues(long[] a, int m, long[] b, int n) {
        if (m == 0 || n == 0) return -1;

        long sumA = Arrays.stream(a).sum();
        long sumB = Arrays.stream(b).sum();

        if ((sumA - sumB) % 2 != 0) return -1;
        long dif = (sumA - sumB) / 2;

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (a[i] - b[j] == dif) {
                return 1;
            } else if (a[i] - b[j] < dif) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        long[] a = {10, 10, 10, 10};//{5, 7, 4, 6};
        long[] b = {5, 5, 5, 10};//{1, 2, 3, 8};

        System.out.println(new SwappingPairs().findSwapValues(a, m, b, n));  // 1
    }
}
