package heap;

public class Operations {
    private final int capacity;
    private int heapSize;
    private final int[] heapArray;

    public Operations(int capacity) {
        this.capacity = capacity;
        heapSize = 0;
        heapArray = new int[capacity];
    }

    public void insertKey(int key) {
        if (heapSize == capacity) return;

        heapSize++;
        int i = heapSize - 1;
        heapArray[i] = key;

        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            int temp = heapArray[parent(i)];
            heapArray[parent(i)] = heapArray[i];
            heapArray[i] = temp;
            i = parent(i);
        }
    }

    public void deleteKey(int i) {
        if (i > heapSize - 1) return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    private void decreaseKey(int i, int newValue) {
        heapArray[i] = newValue;
        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            int temp = heapArray[parent(i)];
            heapArray[parent(i)] = heapArray[i];
            heapArray[i] = temp;
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heapSize <= 0) {
            return -1;
        } else if (heapSize == 1) {
            heapSize--;
            return heapArray[0];
        } else {
            int head = heapArray[0];
            heapArray[0] = heapArray[heapSize - 1];
            heapSize--;
            MinHeapify(0);
            return head;
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (2 * i + 1);
    }

    private int right(int i) {
        return (2 * i + 2);
    }

    private void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && heapArray[l] < heapArray[i]) smallest = l;
        if (r < heapSize && heapArray[r] < heapArray[smallest]) smallest = r;
        if (smallest != i) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[smallest];
            heapArray[smallest] = temp;
            MinHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        Operations minHeap = new Operations(7);

        minHeap.insertKey(4);
        minHeap.insertKey(2);
        System.out.println(minHeap.extractMin());  // 2
        minHeap.insertKey(6);
        minHeap.deleteKey(0);
        System.out.println(minHeap.extractMin());  // 6
        System.out.println(minHeap.extractMin());  // -1
    }
}
