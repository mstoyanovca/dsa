package binary_tree;

public class CompareTwoTrees {
    public boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.data == root2.data) {
                return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(new CompareTwoTrees().isIdentical(root1, root2));  // true
    }
}
