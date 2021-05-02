package hashing;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArrays {
    public long findSubarray(long[] arr, int n) {
        Map<Long, Integer> hash = new HashMap<>();
        long sum = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) count++;
            if (hash.containsKey(sum)) {
                count += hash.get(sum);
                hash.put(sum, hash.get(sum) + 1);
            } else {
                hash.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 30;//6;
        //long[] arr = {0, 0, 5, 5, 0, 0};
        long[] arr = {9, -10, -1, 5, 17, -18, 6, 19, -12, 5, 18, 14, 4, -19, 11, 8, -19, 18, -20, 14, 8, -14, 12, -12, 16, -11, 0, 3, -19, 16};

        System.out.println(new ZeroSumSubArrays().findSubarray(arr, n));  // 6  11
    }
}
