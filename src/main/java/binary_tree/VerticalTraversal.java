package binary_tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalTraversal {
    public ArrayList<Integer> verticalOrder(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<NodeWrapper> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();  // K = hd, V = data

        queue.add(new NodeWrapper(0, root));

        while (!queue.isEmpty()) {
            NodeWrapper nodeWrapper = queue.remove();

            if (map.containsKey(nodeWrapper.hd)) {
                map.get(nodeWrapper.hd).add(nodeWrapper.node.data);
            } else {
                map.put(nodeWrapper.hd, new ArrayList<>(Collections.singletonList(nodeWrapper.node.data)));
            }

            if (nodeWrapper.node.left != null) queue.add(new NodeWrapper(nodeWrapper.hd - 1, nodeWrapper.node.left));
            if (nodeWrapper.node.right != null) queue.add(new NodeWrapper(nodeWrapper.hd + 1, nodeWrapper.node.right));
        }

        return map.values().stream().flatMap(List::stream).collect(Collectors.toCollection(ArrayList::new));
    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class NodeWrapper {
        int hd;
        Node node;

        public NodeWrapper(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(new VerticalTraversal().verticalOrder(root));  // 4, 2, 1, 5, 3, 6
    }
}
