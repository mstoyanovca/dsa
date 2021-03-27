package linkedlist;

public class CheckPalindrome {
    boolean isPalindrome(Node head) {
        int middle = findLength(head) / 2;

        Node secondHalf = head;
        for (int i = 0; i < middle; i++) secondHalf = secondHalf.next;
        secondHalf = reverse(secondHalf);

        for (int i = 0; i < middle; i++) {
            if (head.data != secondHalf.data) return false;
            head = head.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private int findLength(Node head) {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    private Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
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
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(3);

        System.out.println(new CheckPalindrome().isPalindrome(linkedList.head));  // false
    }
}
