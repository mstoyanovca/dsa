package linkedlist;

public class ReverseLinkedList {
    private Node head;

    public Node reverseList(Node node) {
        Node prev = null;
        Node curr = node;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node = prev;
        return node;
    }

    public Node loop(Node node) {
        if (node == null || node.next == null) return node;
        Node tail = loop(node.next);
        node.next.next = node;
        node.next = null;
        return tail;
    }

    private void add(int data) {
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
        ReverseLinkedList linkedList = new ReverseLinkedList();
        for (int i = 6; i > 0; i--) linkedList.add(i);

        // System.out.println(new ReverseLinkedList().reverseList(linkedList.head));  // 6
        System.out.println(new ReverseLinkedList().loop(linkedList.head));  // 6
    }
}
