package linkedlist;

public class Flattening {
    public Node flatten(Node root) {
        int x = 0;

        return null;
    }

    private static class LinkedList {
        Node head;
        Node bottom;

        public void add(int data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList sublist1 = new LinkedList();
        sublist1.add(30);
        sublist1.add(8);
        sublist1.add(7);

        LinkedList sublist2 = new LinkedList();
        sublist2.add(20);

        LinkedList sublist3 = new LinkedList();
        sublist3.add(50);
        sublist3.add(22);

        LinkedList sublist4 = new LinkedList();
        sublist4.add(45);
        sublist4.add(40);
        sublist4.add(35);

        LinkedList linkedList = new LinkedList();
        linkedList.add(28);
        linkedList.head.bottom = sublist4.head;
        linkedList.add(19);
        linkedList.head.bottom = sublist3.head;
        linkedList.add(10);
        linkedList.head.bottom = sublist2.head;
        linkedList.add(5);
        linkedList.head.bottom = sublist1.head;

        new Flattening().flatten(linkedList.head);  // 5->7->8->10->19->20->22->28->30->35->40->45->50
    }
}
