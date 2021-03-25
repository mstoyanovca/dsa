package linkedlist;

public class PairwiseSwap {
    public Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) return head;
        Node first = new Node(head.next.data);
        Node second = new Node(head.data);
        first.next = second;
        Node result = first;

        while (head.next.next != null && head.next.next.next != null) {
            head = head.next.next;
            Node previous = second;
            first = new Node(head.next.data);
            second = new Node(head.data);
            first.next = second;
            previous.next = first;
        }

        return result;
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
        LinkedList linkedList = new LinkedList();
        linkedList.add(8);
        linkedList.add(7);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(1);

        System.out.println(new PairwiseSwap().pairwiseSwap(linkedList.head).data);  // 2
    }
}
