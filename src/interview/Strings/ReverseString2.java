package interview.Strings;

/**
 * Problem number 186
 *
 * @author rajasan
 */
public class ReverseString2 {

    public static char[] reverseString(char[] string, int start, int end) {

        if (string == null || string.length <= 0) {
            return null;
        }

        if (string.length < end || string.length < start) {
            return null;
        }

        int j = end;
        for (int i = start; i <= end; i++) {
            char temp = string[i];
            string[i] = string[j];
            string[j] = temp;
            j--;
            if (j <= i) {
                break;
            }
        }
        return string;
    }

    public static void rev(char[] string) {

        if (string == null || string.length <= 0) {
            return;
        }

        char[] rev = reverseString(string, 0, string.length - 1);

        int j = 0;
        for (int i = 0; i < rev.length; i++) {
            if (rev[i] == ' ') {
                reverseString(rev, j, i - 1);
                j = i + 1;
            }
        }

        reverseString(rev, j, rev.length - 1);

        for (int i = 0; i < rev.length; i++) {
            System.out.print(rev[i]);
        }
    }

    public static void main(String[] args) {

        String string = "test this cola and soap";

        rev(string.toCharArray());

    }

}
