package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SpiralTraversal {
    public ArrayList<Integer> findSpiral(Node root) {
        if (root == null) return new ArrayList<>();

        Deque<Node> ltrDequeue = new LinkedList<>();
        Deque<Node> rtlDequeue = new LinkedList<>();
        rtlDequeue.push(root);

        ArrayList<Integer> result = new ArrayList<>();

        while (!ltrDequeue.isEmpty() || !rtlDequeue.isEmpty()) {
            while (!ltrDequeue.isEmpty()) {
                Node node = ltrDequeue.remove();
                result.add(node.data);

                if (node.left != null) rtlDequeue.addFirst(node.left);
                if (node.right != null) rtlDequeue.addFirst(node.right);
            }
            while (!rtlDequeue.isEmpty()) {
                Node node = rtlDequeue.remove();
                result.add(node.data);

                if (node.right != null) ltrDequeue.addFirst(node.right);
                if (node.left != null) ltrDequeue.addFirst(node.left);
            }
        }

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
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        System.out.println(new SpiralTraversal().findSpiral(root));  // 1, 2, 3, 4, 5, 6, 7
    }
}
