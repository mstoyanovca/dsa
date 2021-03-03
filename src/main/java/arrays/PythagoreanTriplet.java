package arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
    public boolean checkTriplet(int[] arr, int n) {
        arr = Arrays.stream(arr).map(e -> e * e).toArray();
        Arrays.sort(arr);

        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) r--;
                if (arr[l] + arr[r] < arr[i]) l++;
                if (arr[l] + arr[r] == arr[i]) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet();

        int n = 5;
        int[] arr = {3, 2, 4, 6, 5};

        System.out.println(pythagoreanTriplet.checkTriplet(arr, n));  // true
    }
}
