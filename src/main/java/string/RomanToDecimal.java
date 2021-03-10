package string;

public class RomanToDecimal {
    public int romanToDecimal(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            int current = toArabic(str.charAt(i));
            int next = 0;
            if (i + 1 < str.length()) {
                next = toArabic(str.charAt(i + 1));
            }
            if (current >= next) {
                result += current;
            } else {
                result -= current;
            }
        }

        return result;
    }

    private int toArabic(char s) {
        switch (s) {
            case ('I'):
                return 1;
            case ('V'):
                return 5;
            case ('X'):
                return 10;
            case ('L'):
                return 50;
            case ('C'):
                return 100;
            case ('D'):
                return 500;
            case ('M'):
                return 1_000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToDecimal().romanToDecimal("V"));  // 5
        System.out.println(new RomanToDecimal().romanToDecimal("III"));  // 3
    }
}
