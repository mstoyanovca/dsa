package arrays;

import java.util.Arrays;

public class SortArray012 {
    public void sort012(int[] a, int n) {
        if (n < 1 || n > 1_000_000) throw new IllegalArgumentException();
        if (Arrays.stream(a).anyMatch(e -> e < 0 || e > 2)) throw new IllegalArgumentException();

        Arrays.sort(a);
    }

    public static void main(String[] args) {
        SortArray012 sortArray012 = new SortArray012();
        int n = 5;
        int[] arr = {0, 2, 1, 2, 0};

        sortArray012.sort012(arr, n);
        System.out.println(Arrays.toString(arr));  // [0, 0, 1, 2, 2]
    }
}
