package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class EquilibriumPoint {
    public ArrayList<Integer> leaders(int[] arr, int n) {
        int max = -1;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                result.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();

        int n = 5;
        int[] arr = {1, 3, 5, 2, 2};

        System.out.println(equilibriumPoint.leaders(arr, n));  // 3
    }
}
