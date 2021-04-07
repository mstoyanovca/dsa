package binary_tree;

import java.util.ArrayList;

public class LeftView {
    private int rootLevel = 0;

    public ArrayList<Integer> leftView(Node root) {
        return root != null ? loop(root, 1, new ArrayList<>()) : new ArrayList<>();
    }

    private ArrayList<Integer> loop(Node node, int nodeLevel, ArrayList<Integer> result) {
        if (rootLevel < nodeLevel) {
            rootLevel = nodeLevel;
            result.add(node.data);
        }

        if (node.left != null) loop(node.left, nodeLevel + 1, result);
        if (node.right != null) loop(node.right, nodeLevel + 1, result);

        return result;
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
        Node left = new Node(3);
        Node right = new Node(2);
        root.left = left;
        root.right = right;

        System.out.println(new LeftView().leftView(root));  // 1, 3
    }
}
