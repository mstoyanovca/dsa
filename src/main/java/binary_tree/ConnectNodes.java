package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodes {
    public void connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node = null;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node previous = node;
                node = queue.remove();

                if (i > 0) previous.nextRight = node;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            node.nextRight = null;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(2);

        new ConnectNodes().connect(root);
        System.out.println(root);
    }
}
