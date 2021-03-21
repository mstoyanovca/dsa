package linkedlist;

public class ReverseInGroups {
    private Node head;

    public Node reverse(Node head, int k) {
        Node previous = null;
        Node current = head;
        Node next = null;

        int i = 0;
        while (i < k && current != null) {
            next = current.next;

            current.next = previous;
            previous = current;
            current = next;

            i++;
        }

        if (next != null) head.next = reverse(next, k);

        return previous;
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
        ReverseInGroups linkedList = new ReverseInGroups();
        int k = 4;
        for (int i = 8; i > 0; i--) linkedList.add(i);

        System.out.println(linkedList.reverse(linkedList.head, k));  // 4

    }
}
