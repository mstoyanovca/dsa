package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArrayInGroups {
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int groups = n / k;

        for (int group = 0; group < groups; group++) {
            List<Integer> sublist = arr.subList(group * k, (group + 1) * k);
            Collections.reverse(sublist);
        }

        if (groups * k < n) {
            List<Integer> sublist = arr.subList(groups * k, n);
            Collections.reverse(sublist);
        }
    }

    public static void main(String[] args) {
        ReverseArrayInGroups reverseArrayInGroups = new ReverseArrayInGroups();

        int n = 5;
        int k = 3;
        int[] arr = {1, 2, 3, 4, 5};

        reverseArrayInGroups.reverseInGroups(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), n, k);  // 3 2 1 5 4
    }
}
