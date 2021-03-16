package string;

public class AToI {
    public int atoi(String str) {
        int n = str.length();

        int result = 0;
        boolean negative = false;

        for (int i = 0; i < n; i++) {
            int c = str.charAt(i);
            if (c == 45) {
                negative = true;
                continue;
            }
            if (c < 48 || c > 57) return -1;
            result += (c - 48) * pow(n - i - 1);
        }

        return !negative ? result : -result;
    }

    private int pow(int exp) {
        if (exp == 0) return 1;

        int result = 1;
        int i = 0;

        while (i < exp) {
            result *= 10;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AToI().atoi("123"));  // 123
        System.out.println(new AToI().atoi("493aaa"));  // -1
        System.out.println(new AToI().atoi("-123"));  // -1
    }
}
