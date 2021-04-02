package stack_and_queue;

import java.util.Stack;

public class MinimumElement {
    private int minEle;
    private final Stack<Integer> stack = new Stack<>();

    int getMin() {
        if (stack.isEmpty()) return -1;

        return minEle;
    }

    int pop() {
        if (stack.isEmpty()) return -1;
        
        int head = stack.pop();
        if (head < minEle) {
            int result = minEle;
            minEle = 2 * minEle - head;
            return result;
        } else {
            return head;
        }
    }

    void push(int x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
        } else {
            if (x < minEle) {
                stack.push(2 * x - minEle);
                minEle = x;
            } else {
                stack.push(x);
            }
        }
    }

    public static void main(String[] args) {
        MinimumElement minimumElement = new MinimumElement();
        minimumElement.push(2);
        minimumElement.push(3);
        System.out.println(minimumElement.pop());  // 3
        System.out.println(minimumElement.getMin());  // 2
        minimumElement.push(1);
        System.out.println(minimumElement.getMin());  // 1
    }
}
