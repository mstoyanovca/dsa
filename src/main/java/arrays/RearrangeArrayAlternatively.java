package arrays;

import java.util.Arrays;

public class RearrangeArrayAlternatively {
    public void rearrange(int[] arr, int n) {
        if (n < 1 || n > 10_000_000) throw new IllegalArgumentException();
        for (int e : arr) if (e < 1 || e > 10_000_000) throw new IllegalArgumentException();

        int[] copy = Arrays.copyOf(arr, n);
        for (int i = 0; i < n; i++) {
            arr[i] = i % 2 == 0 ? copy[n - 1 - i / 2] : copy[i / 2];
        }
    }

    public static void main(String[] args) {
        RearrangeArrayAlternatively rearrangeArrayAlternatively = new RearrangeArrayAlternatively();

        int n = 6;
        int[] arr = {1, 2, 3, 4, 5, 6};
        rearrangeArrayAlternatively.rearrange(arr, n);
        System.out.println(Arrays.toString(arr));  // {6, 1, 5, 2, 4, 3}
    }
}
