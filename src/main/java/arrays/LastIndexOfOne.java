package arrays;

public class LastIndexOfOne {
    public int lastIndex(String s) {
        int c = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') c = i;
        }
        return c;
    }

    public static void main(String[] args) {
        LastIndexOfOne lastIndexOfOne = new LastIndexOfOne();

        String s = "00001";
        System.out.println(lastIndexOfOne.lastIndex(s));  // 4
    }
}
