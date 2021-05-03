package hashing;

import java.util.HashMap;
import java.util.Map;

public class UncommonCharacters {
    public String uncommonChars(String a, String b) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < 26; i++) hash.put((char) (i + 97), 0);

        for (int i = 0; i < a.length(); i++) hash.put(a.charAt(i), 1);
        for (int i = 0; i < b.length(); i++) {
            if (hash.get(b.charAt(i)) == 1) hash.put(b.charAt(i), -1);
            if (hash.get(b.charAt(i)) == 0) hash.put(b.charAt(i), 2);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++)
            if (hash.get((char) (i + 'a')) == 1 || hash.get((char) (i + 'a')) == 2)
                result.append((char) (i + 'a'));

        return result.length() > 0 ? result.toString() : "-1";
    }

    public static void main(String[] args) {
        String a = "geeksforgeeks";
        String b = "geeksquiz";

        System.out.println(new UncommonCharacters().uncommonChars(a, b));  // fioqruz
    }
}
