package linkedlist;

public class Sort012 {
    public Node segregate(Node head) {
        LinkedList zeroList = new LinkedList();
        Node zeroTail = null;
        LinkedList oneList = new LinkedList();
        Node oneTail = null;
        LinkedList twoList = new LinkedList();

        while (head != null) {
            switch (head.data) {
                case 0:
                    zeroList.add(0);
                    if (zeroTail == null) {
                        zeroTail = zeroList.head;
                    }
                    break;
                case 1:
                    oneList.add(1);
                    if (oneTail == null) {
                        oneTail = oneList.head;
                    }
                    break;
                case 2:
                    twoList.add(2);
                    break;
            }
            head = head.next;
        }

        if (oneTail != null) {
            oneTail.next = twoList.head;
            if (zeroTail != null) zeroTail.next = oneList.head;
        } else {
            if (zeroTail != null) zeroTail.next = twoList.head;
        }
        return zeroList.head;
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
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(0);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(1);

        System.out.println(new Sort012().segregate(linkedList.head).data);  // 0
    }
}
