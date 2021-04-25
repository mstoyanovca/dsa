package recursion;

public class SpecialKeyboard {
    public int optimalKeys(int n) {
        if (n < 7) return n;

        int[] results = new int[n];
        for (int i = 0; i < 6; i++) results[i] = i + 1;

        for (int i = 7; i <= n; i++)
            for (int bp = i - 3; bp >= 1; bp--)
                results[i - 1] = Math.max(results[i - 1], (i - bp - 1) * results[bp - 1]);

        return results[n - 1];
    }

    public int optimalKeysRecursive(int n) {
        if (n < 7) return n;

        int max = 0;
        for (int bp = n - 3; bp > 0; bp--) max = Math.max(max, (n - bp - 1) * optimalKeys(bp));

        return max;
    }

    public static void main(String[] args) {
        int n = 7;

        System.out.println(new SpecialKeyboard().optimalKeys(n));  // 9
    }
}
