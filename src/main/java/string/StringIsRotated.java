package string;

public class StringIsRotated {
    public boolean isRotated(String str1, String str2) {
        if ((str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2)).equals(str2)) {
            return true;
        } else {
            return (str1.substring(2) + str1.substring(0, 2)).equals(str2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringIsRotated().isRotated("amazon", "azonam"));  // true
    }
}
