package arrays;

import java.util.Arrays;

public class MinimumPlatforms {
    public int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int counter = 1;
        int max = 0;

        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (dep[j] >= arr[i]) {
                counter++;
                i++;
            } else if (dep[j] < arr[i]) {
                counter--;
                j++;
            }

            if (max < counter) max = counter;
        }

        return max;
    }

    public static void main(String[] args) {
        MinimumPlatforms minimumPlatforms = new MinimumPlatforms();

        int n = 6;
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(minimumPlatforms.findPlatform(arr, dep, n));
    }
}
