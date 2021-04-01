package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int a) {
        while (!q1.isEmpty()) q2.add(q1.remove());
        q1.add(a);
        while (!q2.isEmpty()) q1.add(q2.remove());
    }

    int pop() {
        return q1.isEmpty() ? -1 : q1.remove();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());  // 2
        queue.push(4);
        System.out.println(queue.pop());  // 3
    }
}
