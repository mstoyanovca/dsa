package string;

public class FormPalindrome {
    public int countMin(String str) {
        char[] arr = str.toCharArray();
        int n = str.length();

        int[][] table = new int[n][n];
        int h, t, insertions;

        for (insertions = 1; insertions < n; ++insertions)
            for (h = 0, t = insertions; t < n; ++h, ++t)
                table[h][t] = arr[h] == arr[t] ?
                        table[h + 1][t - 1] :
                        Math.min(table[h][t - 1], table[h + 1][t]) + 1;

        return table[0][n - 1];
        // return loop(str.toCharArray(), 0, str.length() - 1);
    }

    private int loop(char[] str, int h, int t) {
        if (h > t) return -1;
        if (h == t) return 0;
        if (h == t - 1) return str[h] == str[t] ? 0 : 1;

        return str[h] == str[t] ?
                loop(str, h + 1, t - 1) :
                Math.min(loop(str, h, t - 1), loop(str, h + 1, t)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FormPalindrome().countMin("abcd"));  // 3
        System.out.println(new FormPalindrome().countMin("aa"));  // 2
    }
}
