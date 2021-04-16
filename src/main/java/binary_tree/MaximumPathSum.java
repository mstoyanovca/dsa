package binary_tree;

public class MaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        loop(root);
        return max;
    }

    public int loop(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.data;
        }

        int maxLeft = loop(root.left);
        int maxRight = loop(root.right);

        if (root.left != null && root.right != null) {
            max = Math.max(max, maxLeft + maxRight + root.data);
            return Math.max(maxLeft, maxRight) + root.data;
        } else if (root.left == null) {
            return maxRight + root.data;
        } else {
            return maxLeft + root.data;
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
        Node root = new Node(3);
        root.left = new Node(4);
        root.left.left = new Node(-10);
        root.left.right = new Node(4);
        root.right = new Node(5);

        System.out.println(new MaximumPathSum().maxPathSum(root));  // 16
    }
}
