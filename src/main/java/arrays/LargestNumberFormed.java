package arrays;

import java.math.BigInteger;
import java.util.Arrays;

public class LargestNumberFormed {
    public String printLargest(String[] arr) {
        sort(arr, 0, arr.length - 1);
        return String.join("", arr);
    }

    private void sort(String[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(String[] arr, int l, int m, int r) {
        int leftLength = m - l + 1;
        int rightLength = r - m;

        String[] leftArray = Arrays.copyOfRange(arr, l, l + leftLength);
        String[] rightArray = Arrays.copyOfRange(arr, m + 1, m + 1 + rightLength);

        int leftIndex = 0, rightIndex = 0;
        int mergedIndex = l;

        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (new BigInteger(leftArray[leftIndex] + rightArray[rightIndex]).compareTo(new BigInteger(rightArray[rightIndex] + leftArray[leftIndex])) > 0) {
                arr[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                arr[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < leftLength) {
            arr[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < rightLength) {
            arr[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }

    public static void main(String[] args) {
        LargestNumberFormed largestNumberFormed = new LargestNumberFormed();

        int[] arr1 = {3, 30, 34, 5, 9};
        int[] arr2 = {250, 74, 659, 931, 273, 545, 879, 924};

        System.out.println(largestNumberFormed.printLargest(Arrays.stream(arr1).boxed().map(Object::toString).toArray(String[]::new)));  // 9534330
        System.out.println(largestNumberFormed.printLargest(Arrays.stream(arr2).boxed().map(Object::toString).toArray(String[]::new)));  // 93192487974659545273250
    }
}
