package linkedlist;

public class NthNodeFromEnd {
    public int getNthFromLast(Node head, int n) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < n - 1; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                return -1;
            }
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.data;
    }

    private static class LinkedList {
        Node head;

        public void add(int data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(7);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        System.out.println(new NthNodeFromEnd().getNthFromLast(linkedList.head, n));  // 8
    }
}
