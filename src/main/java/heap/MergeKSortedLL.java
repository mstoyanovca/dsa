package heap;

public class MergeKSortedLL {
    public Node mergeKList(Node[] arr, int k) {
        return mergeAllLists(arr, k - 1);
    }

    private Node mergeAllLists(Node[] arr, int last) {
        while (last != 0) {
            int i = 0, j = last;

            while (i < j) {
                arr[i] = merge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) last = j;
            }
        }

        return arr[0];
    }

    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }

        return result;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int k = 4;

        Node root1 = new Node(1);
        root1.next = new Node(2);
        root1.next.next = new Node(3);

        Node root2 = new Node(4);
        root1.next = new Node(5);

        Node root3 = new Node(5);
        root1.next = new Node(6);

        Node root4 = new Node(7);
        root1.next = new Node(8);

        Node[] arr = {root1, root2, root3, root4};

        Node result = new MergeKSortedLL().mergeKList(arr, k);  // 1, 2, 3, 4, 5, 5, 6, 7, 8
        System.out.println(result.data);  // 1
    }
}
