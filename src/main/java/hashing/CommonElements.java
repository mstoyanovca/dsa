package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CommonElements {
    public ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : v1) {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i) + 1);
            }
        }

        for (int i : v2) {
            if (!map2.containsKey(i)) {
                map2.put(i, 1);
            } else {
                map2.put(i, map2.get(i) + 1);
            }
        }

        for (int i : map1.keySet())
            if (map2.containsKey(i)) for (int j = 0; j < Math.min(map1.get(i), map2.get(i)); j++) result.add(i);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> v1 = new ArrayList<>(Arrays.asList(3, 4, 2, 2, 4));
        ArrayList<Integer> v2 = new ArrayList<>(Arrays.asList(3, 2, 2, 7));

        System.out.println(new CommonElements().common_element(v1, v2));  // 2 2 3
    }
}
