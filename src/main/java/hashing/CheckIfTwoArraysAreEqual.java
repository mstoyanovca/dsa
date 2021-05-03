package hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoArraysAreEqual {
    public boolean check(long[] a, long[] b, int n) {
        Map<Long, Integer> hash = new HashMap<>();
        for (long l : a) {
            if (!hash.containsKey(l)) {
                hash.put(l, 1);
            } else {
                hash.put(l, hash.get(l) + 1);
            }
        }

        for (long l : b) {
            if (hash.containsKey(l)) {
                hash.put(l, hash.get(l) - 1);
            } else {
                return false;
            }
        }

        return hash.values().stream().mapToInt(Integer::intValue).sum() == 0;
    }

    public static void main(String[] args) {
        int n = 5;
        long[] a = {1, 2, 5, 4, 0};
        long[] b = {2, 4, 5, 0, 1};

        System.out.println(new CheckIfTwoArraysAreEqual().check(a, b, n));  // true
    }
}
