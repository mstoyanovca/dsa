package string;

public class AdjacentDuplicates {
    public String remove(String s) {
        return loop(s, s.length());
    }

    private String loop(String s, int initLength) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                char pattern = s.charAt(i);
                while (s.length() > 0 && s.charAt(i) == pattern) s = new StringBuilder(s).deleteCharAt(i).toString();
            }
        }

        return s.length() == initLength ? s : loop(s, s.length());
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeek";
        System.out.println(new AdjacentDuplicates().remove(s1));  // gksforgk

        String s2 = "quhxgrhqqaccxeprunllfieilbothbbmpsg";
        System.out.println(new AdjacentDuplicates().remove(s2));  // quhxgrhqqaccxeprunllfieilbothbbmpsg

        String s3 = "aaa";//""aaaaaaaaaaaaa";
        System.out.println(new AdjacentDuplicates().remove(s3));  //
    }
}
