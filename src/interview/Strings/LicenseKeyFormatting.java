package interview.Strings;

/**
 * @author rajasan
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int k) {

        if (S == null || S.length() == 0) {
            return null;
        }

        String[] x = S.split("-");

        StringBuffer str = new StringBuffer();

        if (x.length == 0) {
            return str.toString();
        }

        String t = S.replace("-", "");

        int rem = t.length() % k;

        if (rem > 0) {
            str.append(t.substring(0, rem).toUpperCase());
            if (rem < t.length()) {
                str.append("-");
            }
        }

        for (int i = rem; i < t.length(); i = i + k) {
            str.append(t.substring(i, i + k).toUpperCase());
            if (i != t.length() - k) {
                str.append("-");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        String string = "2";

        String string2 = "2-5g-3-J";

        String string3 = "5F3Z-2e-9-w";
        String val = licenseKeyFormatting(string, 2);

        System.out.println(string);
        System.out.println(val);

//
//        val = licenseKeyFormatting(string2, 2);
//
//        System.out.println(string2);
//        System.out.println(val);

    }

}
