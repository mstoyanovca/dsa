package binary_tree;

public class LCA {
    public Node lca(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data > n1 && root.data > n2) return lca(root.left, n1, n2);
        if (root.data < n1 && root.data < n2) return lca(root.right, n1, n2);
        return root;
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
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        System.out.println(new LCA().lca(root, 7, 8).data);  //  7
    }
}
