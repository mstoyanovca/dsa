package arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    private int findMinDiff(int[] arr, int n, int m) {
        Arrays.sort(arr);
        int result = arr[n - 1] - arr[0];
        for (int i = 0; i <= n - m; i++) if (arr[m + i - 1] - arr[i] < result) result = arr[m + i - 1] - arr[i];
        return result;
    }

    public static void main(String[] args) {
        ChocolateDistribution chocolateDistribution = new ChocolateDistribution();

        int n = 8;
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;

        System.out.println(chocolateDistribution.findMinDiff(arr, n, m));  // 6
    }
}
