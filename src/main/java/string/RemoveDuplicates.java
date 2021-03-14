package string;

import java.util.Arrays;

public class RemoveDuplicates {
    public String removeDups(String s) {
        int[] arr = new int[26];
        char[] result = s.toCharArray();
        int index = 0;

        int i = 0;
        while (i < s.length()) {
            int j = Character.getNumericValue(s.charAt(i)) - 10;

            if (arr[j] == 0) {
                result[index] = s.charAt(i);
                index++;
                arr[j]++;
                i++;
            } else {
                i++;
            }
        }

        return String.valueOf(Arrays.copyOf(result, index));
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDups("zvvo"));  // zvo
        System.out.println(new RemoveDuplicates().removeDups("gfg"));  // gf
        System.out.println(new RemoveDuplicates().removeDups("qiwekiiroc"));  // qiwekroc
    }
}
