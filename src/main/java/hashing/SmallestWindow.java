package hashing;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindow {
    public String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "-1";
        if (s.length() == 1) return s.equalsIgnoreCase(p) ? p : "-1";

        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            hash.put(p.charAt(i), hash.get(p.charAt(i)) == null ? 1 : hash.get(p.charAt(i)) + 1);
        int left = -1;
        int right = -1;
        int start = -1;
        int min = s.length() + 1;

        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) != null && hash.get(s.charAt(i)) > 0) {
                left = i;
                hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
                if (left + 1 >= s.length()) return "-1";
                break;
            }
        }
        if (left == -1) return "-1";

        for (int i = left + 1; i < s.length(); i++) {
            if (hash.get(s.charAt(i)) != null && hash.get(s.charAt(i)) > 0) {
                hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
                if (hash.values().stream().noneMatch(e -> e != 0)) {
                    start = left;
                    right = i;
                    min = Math.min(min, right - left + 1);
                    break;
                }
            }
        }
        if (start == -1) return "-1";

        while (right < s.length()) {
            char removed = s.charAt(left++);
            while (!hash.containsKey(s.charAt(left))) left++;
            while (s.charAt(right) == removed) right++;
        }

        return start == -1 ? "-1" : s.substring(start, start + min);
    }

    public static void main(String[] args) {
        final String s = "timetopractice";
        final String p = "toc";

        System.out.println(new SmallestWindow().smallestWindow(s, p));  // toprac
    }
}
