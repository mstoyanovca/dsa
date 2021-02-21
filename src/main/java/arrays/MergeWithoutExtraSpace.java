package arrays;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public void merge(int[] arr1, int[] arr2, int n, int m) {
        if (n < 1 || n > 50_000) throw new IllegalArgumentException();
        if (m < 1 || m > 50_000) throw new IllegalArgumentException();
        for (int x : arr1) if (x < 0 || x > 10_000_000) throw new IllegalArgumentException();
        for (int x : arr2) if (x < 0 || x > 10_000_000) throw new IllegalArgumentException();

        int gap = gap(n + m);

        while (gap >= 1) {
            for (int i = 0; i + gap < n + m; i++) {
                if (i + gap < n) {
                    // comparison within arr1:
                    if (arr1[i] > arr1[i + gap]) swap(arr1, i, i + gap);
                } else if (i > n - 1) {
                    // comparison within arr2:
                    if (arr2[i - n] > arr2[i - n + gap]) swap(arr2, i - n, i - n + gap);
                } else {
                    // comparison within both arrays:
                    if (arr1[i] > arr2[i + gap - n]) swap(arr1, arr2, i, i + gap - n);
                }
            }
            gap = gap(gap);
        }
    }

    private int gap(int gap) {
        return gap == 1 ? 0 : gap / 2 + gap % 2;
    }

    private void swap(int[] arr, int i, int j) {
        int acc = arr[i];
        arr[i] = arr[j];
        arr[j] = acc;
    }

    private void swap(int[] arr1, int[] arr2, int i, int j) {
        int acc = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = acc;
    }

    public static void main(String[] args) {
        MergeWithoutExtraSpace mergeWithoutExtraSpace = new MergeWithoutExtraSpace();

        int n = 4;
        int m = 5;
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        mergeWithoutExtraSpace.merge(arr1, arr2, n, m);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
