package hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstElementKTimes {
    public int firstElementKTime(int[] a, int n, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : a) {
            hash.put(i, !hash.containsKey(i) ? 1 : hash.get(i) + 1);
            if (hash.get(i) == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 2;
        int[] a = {1, 7, 4, 3, 4, 8, 7};

        System.out.println(new FirstElementKTimes().firstElementKTime(a, n, k));  // 4
    }
}
