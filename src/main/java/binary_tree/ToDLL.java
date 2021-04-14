package binary_tree;

public class ToDLL {
    Node previous = null;
    Node head;

    public Node bToDLL(Node node) {
        if (node == null) return null;

        bToDLL(node.left);

        if (previous == null) {
            head = node;
        } else {
            previous.right = node;
            node.left = previous;
        }
        previous = node;

        bToDLL(node.right);

        return head;
    }

    private static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right = new Node(15);
        root.right.left = new Node(36);

        Node head = new ToDLL().bToDLL(root);  // 25, 12, 30, 10, 36, 15
        System.out.println(new ToDLL().bToDLL(root));

        // input 1 3 10 5 7 9 N 5 5 9 2 10
        // 5 5 5 3 9 7 2 1 10 9 10
        // 10 9 10 1 2 7 9 3 5 5 5
    }
}
