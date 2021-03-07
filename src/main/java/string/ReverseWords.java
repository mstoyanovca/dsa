package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] arr = s.split("\\.");
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        return String.join(".", list.toArray(new String[0]));
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();

        String s = "i.like.this.program.very.much";

        System.out.println(reverseWords.reverseWords(s));  // much.very.program.this.like.i
    }
}
