package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {
    private double median = 0;

    // store elements greater than the effective median:
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // store elements smaller than the effective median:
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void insertHeap(int x) {
        if (median == 0) median = x;

        if (maxHeap.size() > minHeap.size()) {
            if (x < median) {
                minHeap.add(maxHeap.remove());
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }
            median = !minHeap.isEmpty() && !maxHeap.isEmpty() ? (double) (minHeap.peek() + maxHeap.peek()) / 2 : 0;
        } else if (maxHeap.size() < minHeap.size()) {
            if (x > median) {
                maxHeap.add(minHeap.remove());
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
            median = !minHeap.isEmpty() && !maxHeap.isEmpty() ? (double) (minHeap.peek() + maxHeap.peek()) / 2 : 0;
        } else {
            if (x < median) {
                maxHeap.add(x);
                median = !maxHeap.isEmpty() ? maxHeap.peek() : 0;
            } else {
                minHeap.add(x);
                median = !minHeap.isEmpty() ? minHeap.peek() : 0;
            }
        }
    }

    public void balanceHeaps() {
    }

    public double getMedian() {
        return median;
    }

    public static void main(String[] args) {
        MedianInStream stream = new MedianInStream();

        stream.insertHeap(5);
        System.out.println(stream.getMedian());  // 5

        stream.insertHeap(15);
        System.out.println(stream.getMedian());  // 10

        stream.insertHeap(1);
        System.out.println(stream.getMedian());  // 5

        stream.insertHeap(3);
        System.out.println(stream.getMedian());  // 4
    }
}
