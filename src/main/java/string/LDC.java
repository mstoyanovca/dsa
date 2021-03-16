package string;

public class LDC {
    public int longestSubstrDitinctChars(String s) {
        char[] str = s.toCharArray();
        int n = s.length();

        int[] arr = new int[26];

        int h = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int index = Character.getNumericValue(str[i]) - 10;

            if (arr[index] == 0) {
                arr[index]++;
            } else {
                for (int j = h; j < i; j++) if (str[j] == str[i]) h = j;
                max = Math.max(max, i - h);
                arr = new int[26];
                i--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LDC().longestSubstrDitinctChars("geeksforgeeks"));  // 7
        System.out.println(new LDC().longestSubstrDitinctChars("aaa"));  // 1
        System.out.println(new LDC().longestSubstrDitinctChars("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));  // 10?
    }
}
