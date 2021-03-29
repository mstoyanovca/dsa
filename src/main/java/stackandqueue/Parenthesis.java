package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parenthesis {
    public boolean ispar(String x) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            } else {
                if (stack.isEmpty()) return false;
            }

            switch (c) {
                case '}':
                    if (stack.pop() == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (stack.pop() == '(') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.pop() == '[') {
                        break;
                    } else {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String x = "{([])}";

        System.out.println(new Parenthesis().ispar(x));
    }
}
