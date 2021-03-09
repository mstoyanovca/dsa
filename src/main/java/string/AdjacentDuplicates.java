package string;

public class AdjacentDuplicates {
    private String removeAdjacentDuplicates(int n, String... s) {
        int m = 0;
        StringBuilder result = new StringBuilder();

        while (m < n) {
            for (int i = 0; i < s[m].length() - 1; i++)
                if (s[m].charAt(i) == s[m].charAt(i + 1))
                    s[m] = new StringBuilder(s[m]).deleteCharAt(i).deleteCharAt(i).toString();

            result.append(s[m]).append("\n");
            m++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"geeksforgeek", "quhxgrhqqaccxeprunllfieilbothbbmpsg"};
        System.out.println(new AdjacentDuplicates().removeAdjacentDuplicates(args.length, arr));  // gksforgk
    }
}
