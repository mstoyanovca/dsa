package string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private final List<String> list = new ArrayList<>();

    public List<String> find_permutation(String s) {
        loop(s, 0);
        return list;
    }

    private void loop(String s, int start) {
        if (start < s.length()) {
            for (int i = start; i < s.length(); i++) list.add(swap(s, start, i));
            loop(s, start + 1);
        }
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().find_permutation("ABC"));  // ABC ACB BAC BCA CAB CBA
    }
}
