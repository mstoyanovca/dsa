package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElements {
    public ArrayList<Integer> countDistinct(int[] a, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        result.add(map.size());

        for (int i = k; i < n; i++) {
            if (map.get(a[i - k]) == 1) {
                map.remove(a[i - k]);
            } else {
                map.put(a[i - k], map.get(a[i - k]) - 1);
            }

            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }

            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 4;
        int[] a = {1, 2, 1, 3, 4, 2, 3};

        System.out.println(new CountDistinctElements().countDistinct(a, n, k));  // 3 4 4 3
    }
}
