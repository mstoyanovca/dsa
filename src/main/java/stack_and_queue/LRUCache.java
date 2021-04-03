package stack_and_queue;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private int length;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    private void addFirst(Node node) {
        node.next = head.next;
        node.next.previous = node;
        node.previous = head;
        head.next = node;
        head.previous = null;
        tail.next = null;
        length = 0;
    }

    private void delete(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            delete(node);
            addFirst(node);
            return result;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            addFirst(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (length < capacity) {
                length++;
            } else {
                map.remove(tail.previous.key);
                delete(tail.previous);
            }
            addFirst(node);
        }
    }

    private static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(1, 5);
        cache.set(4, 5);
        cache.set(6, 7);
        System.out.println(cache.get(4));  // 5
        cache.set(1, 2);
        System.out.println(cache.get(3));  // -1
    }
}
