package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingByFrequency {
    private void sortByFrequency(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            List<Integer> subList = new ArrayList<>();
            subList.add(me.getKey());
            subList.add(me.getValue());
            list.add(subList);
        }
        list.sort((l1, l2) -> !l1.get(0).equals(l2.get(0)) ? l1.get(0) - l2.get(0) : l1.get(1) - l2.get(1));

        for (List<Integer> subList : list) {
            for (int i = 0; i < subList.get(1); i++) {
                System.out.print(subList.get(0) + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 5, 4, 6, 4};

        new SortingByFrequency().sortByFrequency(array);  // 4 4 5 5 6
    }
}
