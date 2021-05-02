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
        int n = 6;
        long[] arr = {0, 0, 5, 5, 0, 0};

        System.out.println(new ZeroSumSubArrays().findSubarray(arr, n));  // 6
    }
}
