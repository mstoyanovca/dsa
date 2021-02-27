package arrays;

import java.util.Arrays;

public class CountInversions {
    private long counter;

    public long inversionCount(long[] arr, long n) {
        if (n < 1 || n > 500_000) return 0;
        if (Arrays.stream(arr).anyMatch(e -> e < 1 || e > 1_000_000_000_000_000_000L)) return 0;

        counter = 0;
        // for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) if (arr[i] > arr[j]) counter++;
        split(arr, 0, n - 1);
        return counter;
    }

    private void split(long[] arr, long l, long r) {
        if (l < r) {
            long m = l + (r - l) / 2;
            split(arr, l, m);
            split(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(long[] arr, long l, long m, long r) {
        int leftLength = (int) (m - l + 1);
        int rightLength = (int) (r - m);

        long[] left = Arrays.copyOfRange(arr, (int) l, (int) l + leftLength);
        long[] right = Arrays.copyOfRange(arr, (int) m + 1, (int) m + 1 + rightLength);

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = (int) l;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                counter += leftLength - leftIndex;
                arr[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftLength) {
            arr[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightLength) {
            arr[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }

    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();

        int n = 5;
        long[] arr = {2, 4, 1, 3, 5};

        System.out.println(countInversions.inversionCount(arr, n));  // 3
    }
}
