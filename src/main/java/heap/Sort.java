package heap;

import java.util.Arrays;

public class Sort {
    void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public void heapSort(int[] arr, int n) {
        buildHeap(arr, n);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] array = {4, 1, 3, 9, 7};

        new Sort().heapSort(array, n);
        System.out.println(Arrays.toString(array));  // 1, 3, 4, 7, 9
    }
}
