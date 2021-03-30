package stack_and_queue;

import java.util.Arrays;

public class NGE {
    public long[] nextLargerElement(long[] arr, int n) {
        long[] result = new long[n];
        result[0] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] > result[i - 1]) {
                    result[i - 1] = arr[j];
                    result[i] = arr[i];
                    break;
                }
                if (j == n - 1) {
                    result[i - 1] = -1;
                    result[i] = arr[i];
                }
            }
            if (i == n - 1) result[i] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        long[] arr = {1, 3, 2, 4};
        // long[] arr = {7, 8, 1, 4};
        //long[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(new NGE().nextLargerElement(arr, n)));  // 8, -1, 4, -1
    }
}
