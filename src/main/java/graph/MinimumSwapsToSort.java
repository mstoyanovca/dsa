package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapsToSort {
    public int minSwaps(int[] nums) {
        int result = 0;
        boolean[] visited = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> numberIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) numberIndex.add(new ArrayList<>(Arrays.asList(nums[i], i)));
        numberIndex.sort(Comparator.comparingInt(o -> o.get(0)));

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || numberIndex.get(i).get(1) == i) continue;

            int swaps = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = numberIndex.get(j).get(1);
                swaps++;
            }
            if (swaps > 0) result += swaps - 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 5, 4};

        System.out.println(new MinimumSwapsToSort().minSwaps(nums));  // 1
    }
}
