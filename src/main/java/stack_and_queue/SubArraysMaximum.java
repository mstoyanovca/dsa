package stack_and_queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SubArraysMaximum {
    public ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> qi = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()]) qi.removeLast();
            qi.addLast(i);
        }

        for (int i = k; i < n; i++) {
            result.add(arr[qi.peek()]);
            while ((!qi.isEmpty()) && qi.peek() <= i - k) qi.removeFirst();
            while ((!qi.isEmpty()) && arr[i] >= arr[qi.peekLast()]) qi.removeLast();
            qi.addLast(i);
        }

        result.add(arr[qi.peek()]);

        return result;
    }

    public ArrayList<Integer> max_of_subarrays2(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int max = 0;
            for (int j = i; j < k + i; j++) {
                max = Math.max(arr[j], max);
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        int[] arr = {5, 2, 3, 1, 4, 5, 2, 3, 6};

        System.out.println(new SubArraysMaximum().max_of_subarrays(arr, n, k));  // 3 3 4 5 5 5 6
    }
}
