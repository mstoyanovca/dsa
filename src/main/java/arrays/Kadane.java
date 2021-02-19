package arrays;

public class Kadane {
    public int maxSubarraySum(int[] arr, int n) throws IllegalAccessException {
        if (n < 1 || n > 1000_000) throw new IllegalAccessException();
        for (int e : arr) {
            if (e < -10_000_000 || e > 10_000_000) throw new IllegalAccessException();
        }

        int sum = arr[0];
        
        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            for (int j = i; j < n; j++) {
                tempSum += arr[j];
                if (tempSum > sum) sum = tempSum;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Kadane kadane = new Kadane();

        int n = 5;
        int[] arr = {1, 2, 3, -2, 5};
        System.out.println(kadane.maxSubarraySum(arr, n));
        // 9
    }
}
