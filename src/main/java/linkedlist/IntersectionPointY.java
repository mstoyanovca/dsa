package linkedlist;

public class IntersectionPointY {
    public int intersectPoint(Node head1, Node head2) {
        int l1 = 1;
        int l2 = 1;
        Node p1 = head1;
        Node p2 = head2;

        while (p1.next != null || p2.next != null) {
            if (p1.next != null) {
                l1++;
                p1 = p1.next;
            }
            if (p2.next != null) {
                l2++;
                p2 = p2.next;
            }
        }

        int d = Math.abs(l1 - l2);
        p1 = Math.max(l1, l2) == l1 ? head1 : head2;
        while (p1.next != null && d > 0) {
            d--;
            p1 = p1.next;
        }
        p2 = Math.max(l1, l2) == l1 ? head2 : head1;

        while (p1.next != null && p2.next != null && p1.next != p2.next) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.next != null ? p1.next.data : -1;
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
        LinkedList common = new LinkedList();
        common.add(30);
        common.add(15);

        LinkedList list1 = new LinkedList();
        list1.add(9);
        list1.head.next = common.head;
        list1.add(6);
        list1.add(3);

        LinkedList list2 = new LinkedList();
        list2.add(10);
        list2.head.next = common.head;

        System.out.println(new IntersectionPointY().intersectPoint(list1.head, list2.head));  // 15

        common = new LinkedList();
        common.add(12);
        common.add(23);
        common.add(47);
        common.add(63);
        common.add(17);
        common.add(23);
        common.add(88);

        list1 = new LinkedList();
        list1.add(91);
        list1.head.next = common.head;
        list1.add(24);
        list1.add(60);
        list1.add(5);
        list1.add(14);
        list1.add(36);
        list1.add(84);
        list1.add(7);

        list2 = new LinkedList();
        list2.add(21);
        list2.head.next = common.head;
        list2.add(68);
        list2.add(60);
        list2.add(10);
        list2.add(4);
        list2.add(88);

        System.out.println(new IntersectionPointY().intersectPoint(list1.head, list2.head));  // 88
    }
}
