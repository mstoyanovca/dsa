package linkedlist;

public class AddTwoNumbers {
    public Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);

        int overflow = 0;
        Node head = null;
        Node current = null;

        while (first != null || second != null) {
            int firstData = first != null ? first.data : 0;
            int secondData = second != null ? second.data : 0;
            int sum = firstData + secondData + overflow;
            int digit = sum > 9 ? sum - 10 : sum;
            overflow = sum > 9 ? 1 : 0;

            if (current == null) {
                current = new Node(digit);
                current.next = head;
                head = current;
            } else {
                current.next = new Node(digit);
                current = current.next;
            }

            if (first != null) first = first.next;
            if (second != null) second = second.next;
            if (first == null && second == null && overflow == 1) {
                current.next = new Node(1);
                current = current.next;
            }
        }

        return reverse(head);
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
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(5);
        linkedList1.add(4);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(5);
        linkedList2.add(4);
        linkedList2.add(3);

        System.out.println(new AddTwoNumbers().addTwoLists(linkedList1.head, linkedList2.head).data);  // 3
        // first 7 7 0 3 2
        // second 2 9 6 6 0
        // result 1 0 6 6 9 2
    }
}
