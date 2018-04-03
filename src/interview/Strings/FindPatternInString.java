package interview.Strings;

/**
 * KMP Knutt Morris Pratt Pattern searching
 *
 * @author rajasan
 */
public class FindPatternInString {

    public boolean checkPattern(String text, String pattern) {
        if (pattern == null || text == null) {
            return false;
        }

        int[] a = buildPrefixArray(pattern);

        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
            } else {
                if (j > 0) {
                    j = a[j - 1];
                    i--;
                }
            }
        }

        return j == pattern.length();

    }

    public int[] buildPrefixArray(String s) {

        int j = 0;
        int i = 1;

        int[] a = new int[s.length()];
        a[0] = 0;

        while (i < s.length()) {
            if (s.charAt(j) == s.charAt(i)) {
                a[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = a[j - 1];
                } else {
                    a[i++] = 0;
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        FindPatternInString f = new FindPatternInString();
        for (int i : f.buildPrefixArray("acacabacacabacacac"))
            System.out.print(i + "|");

        System.out.println();
        System.out.println(f.checkPattern("abxabcabcaby", "abcaby"));
    }

}
