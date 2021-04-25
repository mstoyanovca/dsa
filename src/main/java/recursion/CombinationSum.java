package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] a, int length, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        loop(Arrays.stream(a).boxed().sorted().collect(Collectors.toList()), 0, sum, result, new ArrayList<>());
        return result;
    }

    private void loop(List<Integer> arr,
                      int index,
                      int sum,
                      List<List<Integer>> result,
                      List<Integer> partial) {
        if (sum == 0) {
            Collections.sort(partial);
            if (!result.contains(partial)) result.add(new ArrayList<>(partial));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if ((sum - arr.get(i)) >= 0) {
                partial.add(arr.get(i));
                loop(arr, i + 1, sum - arr.get(i), result, partial);
                partial.remove(arr.get(i));
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int sum = 8;
        int[] a = {9, 1, 2, 7, 6, 1, 5};

        System.out.println(new CombinationSum().combinationSum(a, n, sum));  // (1 1 6)(1 2 5)(1 7)(2 6)
    }
}
