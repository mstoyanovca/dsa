package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianInStream {
    private final List<Integer> list = new ArrayList<>();

    public void insertHeap(int x) {
        list.add(x);
        balanceHeaps();
    }

    public void balanceHeaps() {
        Collections.sort(list);
    }

    public double getMedian() {
        if (list.size() == 1) return list.get(0);
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2 - 1);
        } else {
            int left = list.get(list.size() / 2 - 1);
            int right = list.get(list.size() / 2);
            return (left + right) / 2;
        }
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
