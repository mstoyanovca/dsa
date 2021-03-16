package string;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    String longestCommonPrefix(String[] arr, int n) {
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr[0].length(); i++) {
            char c = arr[0].charAt(i);
            for (int j = 0; j < n; j++) {
                if (arr[j].charAt(i) != c) return result.length() == 0 ? "-1" : result.toString();
            }
            result.append(c);
        }

        return result.length() == 0 ? "-1" : result.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr, n));
    }
}
