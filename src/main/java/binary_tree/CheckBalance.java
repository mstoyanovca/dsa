package binary_tree;

public class CheckBalance {
    public boolean isBalanced(Node root) {
        if (root == null) return true;
        return !(Math.abs(height(root.left) - height(root.right)) > 1)
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
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
        root.left = new Node(10);
        root.left.left = new Node(5);
        root.right = new Node(39);

        System.out.println(new CheckBalance().isBalanced(root));
    }
}
