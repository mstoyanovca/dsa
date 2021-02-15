package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubArrayWithGivenSum {
    public ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        if (n <= 0 || s < 0) return new ArrayList<>(Collections.singletonList(-1));

        return Arrays
                .stream(recursive(arr, 0, 0, s, n))
                .boxed()
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
    }

    private int[] recursive(int[] arr, int startIndex, int endIndex, int s, int n) {
        int tempSum = Arrays.stream(Arrays.copyOfRange(arr, startIndex, endIndex + 1)).sum();

        if (tempSum == s) {
            // 1 index-based:
            return new int[]{startIndex + 1, endIndex + 1};
        } else if (tempSum < s) {
            return endIndex == n - 1 ?
                    new int[]{-1} :
                    recursive(arr, startIndex, endIndex + 1, s, n);
        } else {
            return startIndex == n - 1 ?
                    new int[]{-1} :
                    recursive(arr, startIndex + 1, endIndex, s, n);
        }
    }

    public static void main(String[] args) {
        SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
        int n = 5;
        int s = 12;
        int[] arr = {1, 2, 3, 7, 5};

        System.out.println(subArrayWithGivenSum.subarraySum(arr, n, s));
        // [2, 4]

        n = 10;
        s = 15;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(subArrayWithGivenSum.subarraySum(arr, n, s));
        // [1, 5]

        n = 3;
        s = 20;
        arr = new int[]{1, 2, 3};

        System.out.println(subArrayWithGivenSum.subarraySum(arr, n, s));
        // [-1]

        n = 100_000;
        s = 111_111;
        arr = new int[n];
        for (int x = 0; x < n; x++) {
            arr[x] = x;
        }
        System.out.println(subArrayWithGivenSum.subarraySum(arr, n, s));
        // [?, ?]
    }
}
