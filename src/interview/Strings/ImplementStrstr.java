package interview.Strings;

/**
 * @author rajasan
 */
public class ImplementStrstr {

    public static int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (!haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }

        int len = needle.length();
        for (int i = 0; i < haystack.length() - len + 1; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ello"));
    }

}
