package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int findLongestConseqSubseq(int[] arr, int n) {
        Map<Integer, Integer> hash = new HashMap<>();
        int max = 0;

        for (int i : arr) hash.put(i, 1);

        for (int i : arr) {
            // this element is a start of a sequence:
            if (!hash.containsKey(i - 1)) {
                int temp = 1;
                while (hash.containsKey(i + 1)) {
                    i++;
                    temp++;
                }
                max = Math.max(max, temp);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {2, 6, 1, 9, 4, 5, 3};

        System.out.println(new LongestConsecutiveSequence().findLongestConseqSubseq(arr, n));  // 6
    }
}
