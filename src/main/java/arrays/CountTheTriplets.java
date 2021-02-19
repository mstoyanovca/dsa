package arrays;

public class CountTheTriplets {
    public int countTriplet(int[] arr, int n) {
        if (n < 3 || n > 10_000) return 0;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int[] arrWithoutSum = copy(arr, n, i);
            int sum = arr[i];
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    if (arrWithoutSum[j] + arrWithoutSum[k] == sum) counter++;
                }
            }
        }

        return counter;
    }

    private int[] copy(int[] arr, int n, int indexToRemove) {
        int[] newArr = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i < indexToRemove) newArr[i] = arr[i];
            if (i > indexToRemove) newArr[i - 1] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        CountTheTriplets countTheTriplets = new CountTheTriplets();

        int[] arr = {1, 5, 3, 2};
        int n = 4;
        System.out.println(countTheTriplets.countTriplet(arr, n));  // 2
    }
}
