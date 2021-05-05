package hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {
    public String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";

        Map<Character, Integer> hash_p = new HashMap<>();
        Map<Character, Integer> hash_s = new HashMap<>();
        int count = 0;
        int left = 0;
        int start = -1;
        int min = s.length() + 1;

        for (int i = 0; i < p.length(); i++)
            hash_p.put(p.charAt(i), hash_p.get(p.charAt(i)) == null ? 1 : hash_p.get(p.charAt(i)) + 1);

        for (int i = 0; i < s.length(); i++) {
            if (hash_p.containsKey(s.charAt(i))) {
                hash_s.put(s.charAt(i), hash_s.get(s.charAt(i)) == null ? 1 : hash_s.get(s.charAt(i)) + 1);
                if (hash_s.get(s.charAt(i)) <= hash_p.get(s.charAt(i))) count++;

                if (count == p.length()) {
                    while (!hash_p.containsKey(s.charAt(left)) || hash_s.containsKey(s.charAt(left)) && hash_s.get(s.charAt(left)) > hash_p.get(s.charAt(left))) {
                        if (hash_s.containsKey(s.charAt(left)) && hash_s.get(s.charAt(left)) > hash_p.get(s.charAt(left)))
                            hash_s.put(s.charAt(left), hash_s.get(s.charAt(left)) - 1);
                        left++;
                    }
                    min = Math.min(min, i - left + 1);
                    start = left;
                }
            }
        }

        return start == -1 ? "-1" : s.substring(left, left + min);
    }

    public static void main(String[] args) {
        final String s = "timetopractice";
        final String p = "toc";

        System.out.println(new SmallestWindow().smallestWindow(s, p));  // toprac
    }
}
