package string;

public class Anagram {
    public boolean isAnagram(String a, String b) {
        int[] arr = new int[26];

        for (int i = 0; i < a.length(); i++) {
            arr[Character.getNumericValue(a.charAt(i)) - 10]++;
        }

        for (int i = 0; i < b.length(); i++) {
            arr[Character.getNumericValue(b.charAt(i)) - 10]--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("geeksforgeeks", "forgeeksgeeks"));  // true
        System.out.println(new Anagram().isAnagram("allergy", "allergic"));  // false
    }
}
