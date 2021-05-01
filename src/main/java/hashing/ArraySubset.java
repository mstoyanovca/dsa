package hashing;

import java.util.HashMap;
import java.util.Map;

public class ArraySubset {
    public String isSubset(long[] a1, long[] a2, long m, long n) {
        if (m < n) return "No";

        Map<Long, Integer> hash = new HashMap<>();
        for (long i : a1) hash.put(i, 1);

        for (long i : a2) if (!hash.containsKey(i)) return "No";
        return "Yes";
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        long[] a1 = {11, 1, 13, 21, 3, 7};
        long[] a2 = {11, 3, 7, 1};

        System.out.println(new ArraySubset().isSubset(a1, a2, m, n));  // Yes
    }
}
