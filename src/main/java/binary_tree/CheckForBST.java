package binary_tree;

public class CheckForBST {
    public boolean isBST(Node root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstUtil(Node node, int min, int max) {
        if (node == null) return true;
        if (node.data < min || node.data > max) return false;
        return isBstUtil(node.left, min, node.data - 1) && isBstUtil(node.right, node.data + 1, max);
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
        Node root = new Node(2);
        Node left = new Node(1);
        Node right = new Node(3);
        root.left = left;
        root.right = right;

        System.out.println(new CheckForBST().isBST(root));  // true
    }
}
