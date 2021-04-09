package binary_tree;

import java.util.*;

public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        root.hd = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int hd = node.hd;
            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int data) {
            this.data = data;
            hd = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        System.out.println(new BottomView().bottomView(root));  // 40, 20, 60, 30
    }
}
