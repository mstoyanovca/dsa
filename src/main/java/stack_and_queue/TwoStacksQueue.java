package stack_and_queue;

import java.util.Stack;

public class TwoStacksQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int x) {
        while (!s2.isEmpty()) s1.push(s2.pop());
        s1.push(x);
    }

    int pop() {
        while (!s1.isEmpty()) s2.push(s1.pop());
        return s2.isEmpty() ? -1 : s2.pop();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.push(2);
        queue.push(3);
        System.out.print(queue.pop());  // 2
        queue.push(4);
        System.out.print(queue.pop());  // 3
    }
}
