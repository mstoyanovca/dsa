package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int[] kthLargest(int k, int[] arr, int n) {
        int[] result = new int[n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                minHeap.add(arr[i]);
                result[i] = -1;
            } else if (i == k - 1) {
                minHeap.add(arr[i]);
                result[i] = minHeap.peek();
            } else {
                if (arr[i] > minHeap.peek()) {
                    minHeap.remove();
                    minHeap.add(arr[i]);
                    result[i] = minHeap.peek();
                }
                result[i] = minHeap.peek();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 6;
        int[] arr = {6, 2, 3, 4, 5, 1};

        System.out.println(Arrays.toString(new KthLargestElement().kthLargest(k, arr, n)));  // -1 -1 -1 2 3 3
    }
}
