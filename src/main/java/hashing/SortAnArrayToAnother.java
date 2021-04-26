package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortAnArrayToAnother {
    public int[] sortA1ByA2(int[] a1, int m, int[] a2, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        int index = 0;
        for (int i : a2) {
            if (map.get(i) != null) for (int j = 0; j < map.get(i); j++) a1[index++] = i;
            map.remove(i);
        }

        List<Integer> remaining = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = index; i < m; i++) a1[i] = remaining.get(i - index);

        return a1;
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 4;
        int[] a1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] a2 = {2, 1, 8, 3};

        System.out.println(Arrays.toString(new SortAnArrayToAnother().sortA1ByA2(a1, n, a2, m)));  // 2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9
    }
}
