package linkedlist;

public class Rotation {
    private Node head;

    public Node rotate(Node head, int k) {
        Node k_p = head;
        Node k1_p = head.next != null ? head.next : null;
        Node tail = head;

        int i = 1;
        while (tail.next != null) {
            tail = tail.next;
            if (i < k) {
                i++;
                k_p = k_p.next;
                k1_p = k_p.next;
            }
        }

        if (k1_p != null) {
            k_p.next = null;
            tail.next = head;
            head = k1_p;
        }

        return head;
    }

    public void add(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        Rotation linkedList = new Rotation();
        for (int i = 8; i > 0; i--) linkedList.add(i);

        System.out.println(linkedList.rotate(linkedList.head, 4));  // 5
    }
}
