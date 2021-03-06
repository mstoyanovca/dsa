package arrays;

import java.util.Arrays;

public class ZigZag {
    public void zigZag(int[] arr, int n) {
        int i = 0;
        boolean leftSmaller = true;

        while (i < n - 1) {
            if (leftSmaller && arr[i] > arr[i + 1] || !leftSmaller && arr[i] < arr[i + 1]) swap(arr, i);
            leftSmaller = !leftSmaller;
            i++;
        }
    }

    private void swap(int[] arr, int i) {
        int tmp = arr[i + 1];
        arr[i + 1] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();

        int n = 7;
        int[] arr = {4, 3, 7, 8, 6, 2, 1};

        zigZag.zigZag(arr, n);
        System.out.println(Arrays.toString(arr));  // 3 7 4 8 2 6 1
    }
}
