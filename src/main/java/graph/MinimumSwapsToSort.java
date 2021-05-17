package graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;

public class MinimumSwapsToSort {
    public int minSwaps(int[] nums) {
        int result = 0;
        boolean[] visited = new boolean[nums.length];
        ArrayList<Pair<Integer, Integer>> numberIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) numberIndex.add(new Pair<>(nums[i], i));
        numberIndex.sort(Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || numberIndex.get(i).getValue() == i) continue;

            int swaps = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = numberIndex.get(j).getValue();
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
