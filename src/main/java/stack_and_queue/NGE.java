package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class NGE {
    public long[] nextLargerElement(long[] arr, int n) {
        long[] result = new long[n];
        Deque<Long> stack = new ArrayDeque<>();
        List<Long> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            result[i] = -1;
            while (!stack.isEmpty() && arr[i] > stack.getFirst()) {
                Long popped = stack.pop();
                result[list.indexOf(popped)] = arr[i];
            }
            stack.push(arr[i]);
        }

        return result;
    }

    public long[] nextLargerElement2(long[] arr, int n) {
        long[] result = new long[n];
        result[0] = arr[0];

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] > result[i - 1]) {
                    result[i - 1] = arr[j];
                    result[i] = arr[i];
                    break;
                }
                if (j == n - 1) {
                    result[i - 1] = -1;
                    result[i] = arr[i];
                }
            }
            if (i == n - 1) result[i] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 14;
        long[] arr = {10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};

        System.out.println(Arrays.toString(new NGE().nextLargerElement(arr, n)));  // 12 12 13 9 9 13 -1 8 11 -1 7 -1 6 -1
    }
}
