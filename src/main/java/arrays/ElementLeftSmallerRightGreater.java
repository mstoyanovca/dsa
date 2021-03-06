package arrays;

public class ElementLeftSmallerRightGreater {
    public int findElement(int[] arr, int n) {
        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = arr[0];
        for (int i = 1; i < n; i++) max[i] = Math.max(arr[i], max[i - 1]);

        min[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(arr[i], min[i + 1]);

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= max[i - 1] && arr[i] <= min[i + 1]) return arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        ElementLeftSmallerRightGreater elementLeftSmallerRightGreater = new ElementLeftSmallerRightGreater();

        int n = 14;
        int[] arr1 = {5, 6, 4, 1, 7, 12, 9, 1, 4, 1, 11, 5, 7, 1};
        System.out.println(elementLeftSmallerRightGreater.findElement(arr1, n));  // -1

        n = 4;
        int[] arr2 = {4, 2, 5, 7};
        System.out.println(elementLeftSmallerRightGreater.findElement(arr2, n));  // 5

        n = 3;
        int[] arr3 = {6, 1, 10};
        System.out.println(elementLeftSmallerRightGreater.findElement(arr3, n));  // -1

        n = 10;
        int[] arr4 = {10, 6, 3, 1, 5, 11, 6, 1, 11, 12};
        System.out.println(elementLeftSmallerRightGreater.findElement(arr4, n));  // 11
    }
}
