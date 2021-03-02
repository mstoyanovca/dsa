package arrays;

public class TrappingRainWater {
    public int trappingWater(int[] arr, int n) {
        int v = 0;
        int[] leftWalls = new int[n];
        int[] rightWalls = new int[n];

        leftWalls[0] = arr[0];
        for (int i = 1; i < n; i++) leftWalls[i] = Math.max(leftWalls[i - 1], arr[i]);

        rightWalls[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) rightWalls[i] = Math.max(rightWalls[i + 1], arr[i]);

        for (int i = 0; i < n; i++) v += Math.min(leftWalls[i], rightWalls[i]) - arr[i];

        return v;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();

        int n = 10;
        int[] arr = {1, 1, 5, 2, 7, 6, 1, 4, 2, 3};

        System.out.println(trappingRainWater.trappingWater(arr, n));  // 7
    }
}
