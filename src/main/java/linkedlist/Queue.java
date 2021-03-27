package linkedlist;

public class Queue {
    QueueNode front, rear;

    private void push(int data) {
        QueueNode node = new QueueNode(data);
        if (front == null) front = node;
        if (rear != null) rear.next = node;
        rear = node;
    }

    private int pop() {
        if (front != null) {
            int result = front.data;
            front = front.next;
            if (front == null) rear = null;
            return result;
        } else {
            return -1;
        }
    }

    private static class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(2);
        queue.push(3);

        int x = queue.pop();

        System.out.println(queue);
    }
}
