package hashing;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexedCharacter {
    public int minIndexChar(String str, String patt) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            if (!hash.containsKey(str.charAt(i))) {
                hash.put(str.charAt(i), i);
            }

        int min = str.length() + 1;
        for (int i = 0; i < patt.length(); i++)
            if (hash.containsKey(patt.charAt(i)))
                min = Math.min(min, hash.get(patt.charAt(i)));

        return min > str.length() ? -1 : min;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String patt = "set";

        System.out.println(new MinimumIndexedCharacter().minIndexChar(str, patt));  // 1
    }
}
