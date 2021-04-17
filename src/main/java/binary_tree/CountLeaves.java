package binary_tree;

public class CountLeaves {
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(10);
        root.left.left = new Node(5);
        root.right = new Node(39);

        System.out.println(new CountLeaves().countLeaves(root));  // 2
    }
}
