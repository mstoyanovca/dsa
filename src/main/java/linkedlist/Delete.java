package linkedlist;

public class Delete {
    public void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
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
        linkedList.add(30);
        linkedList.add(4);
        linkedList.add(20);
        linkedList.add(10);

        new Delete().deleteNode(linkedList.head.next);  // 10, 4, 30
    }
}
