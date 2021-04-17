package binary_tree;

import java.util.ArrayList;

public class SerializeDeserialize {
    public void serialize(Node root, ArrayList<Integer> result) {
        if (root == null) {
            result.add(-1);
            return;
        }

        result.add(root.data);

        if (root.left != null) serialize(root.left, result);
        if (root.right != null) serialize(root.right, result);
    }

    public Node deSerialize(ArrayList<Integer> list) {
        if (list.isEmpty()) return null;
        Node node = new Node(list.get(0));
        list.remove(0);
        node.left = deSerialize(list);
        node.right = deSerialize(list);
        return node;
    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        /*Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right = new Node(30);*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        ArrayList<Integer> result = new ArrayList<>();
        new SerializeDeserialize().serialize(root, result);
        System.out.println(result);

        System.out.println(new SerializeDeserialize().deSerialize(result));
    }
}
