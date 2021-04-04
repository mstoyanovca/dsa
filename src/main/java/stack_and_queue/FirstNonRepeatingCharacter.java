package stack_and_queue;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacter {
    public String firstNonRepeating(String s) {
        final int[] arr = new int[26];
        StringBuilder result = new StringBuilder();
        List<Character> nrc = new ArrayList<>();

        for (char c : s.toCharArray()) {
            arr[Character.getNumericValue(c) - 10]++;

            if (arr[Character.getNumericValue(c) - 10] == 1) {
                nrc.add(c);
            } else {
                if (nrc.contains(c)) nrc.remove((Character) c);
            }

            if (!nrc.isEmpty()) {
                result.append(nrc.get(0));
            } else {
                result.append('#');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharacter().firstNonRepeating("hrqcvsvszpsjammdrw"));  // hhhhhhhhhhhhhhhhhh
    }
}
