package linkedlist;

public class FindMiddleElement {
    private Node head;

    public int getMiddle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        if (head != null) {
            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }

        return slowPointer != null ? slowPointer.data : -1;
    }

    private void add(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        FindMiddleElement linkedList = new FindMiddleElement();
        for (int i = 6; i > 0; i--) linkedList.add(i);
        System.out.println(new FindMiddleElement().getMiddle(linkedList.head));  // 3
    }
}
