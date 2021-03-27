package linkedlist;

public class Stack {
    private StackNode top;

    public void push(int data) {
        StackNode stackNode = new StackNode(data);
        stackNode.next = top;
        top = stackNode;
    }

    public int pop() {
        if (top != null) {
            int result = top.data;
            top = top.next;
            return result;
        } else {
            return -1;
        }
    }

    private static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // 3
        stack.push(4);
        stack.pop();  // 4
    }
}
