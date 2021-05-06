package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqCanBeEqual {
    public boolean sameFreq(String s) {
        Map<Character, Integer> hash_s = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            hash_s.put(s.charAt(i), !hash_s.containsKey(s.charAt(i)) ? 1 : hash_s.get(s.charAt(i)) + 1);

        Map<Integer, Integer> hash_freq = new HashMap<>();
        for (int freq : hash_s.values())
            hash_freq.put(freq, !hash_freq.containsKey(freq) ? 1 : hash_freq.get(freq) + 1);

        if (hash_freq.size() == 1) {
            return true;
        } else if (hash_freq.size() == 2) {
            List<Integer> freqs = new ArrayList<>(hash_freq.keySet());
            return Math.abs(freqs.get(0) - freqs.get(1)) == 1 || freqs.contains(1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FreqCanBeEqual().sameFreq("xyyz"));  // true
        System.out.println(new FreqCanBeEqual().sameFreq("xxxxyyzz"));  // false
        System.out.println(new FreqCanBeEqual().sameFreq("abababc"));  // true
    }
}
