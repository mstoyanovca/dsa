package linkedlist;

public class RemoveLoop {
    public void removeLoop(Node head) {
        Node slow_p = head;
        Node fast_p = head;
        boolean loop = false;

        // find is there a loop:
        while (slow_p != null && slow_p.next != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            if (slow_p == fast_p) {
                loop = true;
                break;
            }
        }
        if (!loop) return;

        // find number of nodes in loop:
        Node loopNode = slow_p;
        int nodesInLoop = 1;
        while (slow_p.next != loopNode) {
            nodesInLoop++;
            slow_p = slow_p.next;
        }

        // fix one pointer to head:
        Node p1 = head;
        // and the other pointer to nodesInLoop nodes after head:
        Node p2 = head;
        for (int i = nodesInLoop; i > 0; i--) p2 = p2.next;
        // Move both pointers at the same pace, they will meet at loop starting node:
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // find end of loop:
        while (p2.next != p1) p2 = p2.next;
        p2.next = null;
    }

    private static class LinkedList {
        private Node head;

        private void add(int data) {
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
        linkedList.add(16);
        linkedList.add(34);
        linkedList.add(36);
        linkedList.add(58);
        linkedList.add(7);
        linkedList.head.next.next.next.next.next = linkedList.head;

        System.out.println(linkedList.head.next.next.next.next.next.data);  // 7
        new RemoveLoop().removeLoop(linkedList.head);
        System.out.println(linkedList.head.next.next.next.next.next);  // null

        linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.head.next.next.next = linkedList.head.next;

        System.out.println(linkedList.head.next.next.next.data);  // 3
        new RemoveLoop().removeLoop(linkedList.head);
        System.out.println(linkedList.head.next.next.next);  // null
    }
}
