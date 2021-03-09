package string;

public class LongestPalindrome {
    private String findLongestPalindrome(String s) {
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String ss = s.substring(i, j);
                String reversedSs = new StringBuilder(ss).reverse().toString();
                if (ss.equals(reversedSs) && ss.length() > max) {
                    start = i;
                    max = ss.length();
                }
            }
        }

        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().findLongestPalindrome("aaaabbaa"));  // aabbaa
    }
}
