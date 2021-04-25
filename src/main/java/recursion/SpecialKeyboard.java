package recursion;

public class SpecialKeyboard {
    public int optimalKeys(int n) {
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
