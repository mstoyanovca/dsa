package hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSumNumbers {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    if (arr[i] + arr[j] + arr[left] + arr[right] == sum) {
                        ArrayList<Integer> subList = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        if (!result.contains(subList)) result.add(subList);
                    }
                    if (arr[i] + arr[j] + arr[left] + arr[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int sum = 23;
        int[] arr = {10, 2, 3, 4, 5, 7, 8};

        System.out.println(new FourSumNumbers().fourSum(arr, sum));  // [[2, 3, 8, 10], [2, 4, 7, 10], [3, 5, 7, 8]]
    }
}
