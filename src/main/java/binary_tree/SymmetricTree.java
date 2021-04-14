package binary_tree;

public class SymmetricTree {
    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return loop(root.left, root.right);
    }

    private boolean loop(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            if (left.data == right.data) {
                return loop(left.left, right.right) && loop(left.right, right.left);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.right = new Node(1);
        root.right.right = new Node(2);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
