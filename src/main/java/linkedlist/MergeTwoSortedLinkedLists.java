package linkedlist;

public class MergeTwoSortedLinkedLists {
    public Node sortedMerge(Node head1, Node head2) {
        Node result = new Node(-1);
        Node current = result;

        while (true) {
            if (head1 == null) {
                current.next = head2;
                break;
            } else if (head2 == null) {
                current.next = head1;
                break;
            }

            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        return result.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private static class LinkedList {
        Node head;

        public void add(int data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(40);
        linkedList1.add(15);
        linkedList1.add(10);
        linkedList1.add(5);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(20);
        linkedList2.add(3);
        linkedList2.add(2);

        System.out.println(new MergeTwoSortedLinkedLists().sortedMerge(linkedList1.head, linkedList2.head).data);  // 2 3 5 10 15 20 40
    }
}
