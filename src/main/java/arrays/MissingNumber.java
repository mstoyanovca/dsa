package arrays;

import java.util.Arrays;

public class MissingNumber {
    public int missingNo(int[] arr, int n) {
        if (n < 1 || n > 1_000_000) return 0;
        for (int i : arr) {
            if (i < 1 || i > 1_000_000) return 0;
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != i + 1) return i + 1;
            if (i == n - 2) return n;
        }

        return 0;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();

        int n = 5;
        int[] arr = {1, 2, 3, 5};
        System.out.println(missingNumber.missingNo(arr, n));  // 4
    }
}
