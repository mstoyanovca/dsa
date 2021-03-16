package string;

public class StrStr {
    public int strstr(String s, String x) {
        for (int i = 0; i <= s.length() - x.length(); i++)
            if (s.substring(i).startsWith(x))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr().strstr("lrnkbldxguzgcseccinlizyogwqzlifxcthdgmanjztlt", "an"));  // 38
        System.out.println(new StrStr().strstr("abcabcabcd", "abcd"));  // 6
    }
}
