package binary_tree;

public class Height {
    public int height(Node root) {
        return loop(root, 0);
    }

    private int loop(Node node, int height) {
        if (node == null) return height;
        return Math.max(loop(node.left, height + 1), loop(node.right, height + 1));
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(new Height().height(root));  // 2
    }
}
