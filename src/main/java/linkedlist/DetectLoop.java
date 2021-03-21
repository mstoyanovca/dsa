package linkedlist;

public class DetectLoop {
    public boolean detectLoop(Node head) {
        Node slow_p = head;
        Node fast_p = head;

        while (slow_p != null && slow_p.next != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) return true;
        }

        return false;
    }

    private static class LinkedList {
        private Node head;

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
        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.head.next.next.next = linkedList.head.next;

        System.out.println(new DetectLoop().detectLoop(linkedList.head));  // true
    }
}
