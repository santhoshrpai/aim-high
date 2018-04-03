package interview.Strings;

/**
 * @author rajasan
 */
public class RepeatedSubstringMatch {

    public int repeatedStringMatch(String A, String B) {

        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return -1;
        }

        StringBuffer buffer = new StringBuffer();
        int count = 0;

        while (buffer.length() < B.length()) {
            buffer.append(A);
            count++;
        }

        if (buffer.toString().contains(B)) {
            return count;
        } else if (buffer.append(A).toString().contains(B)) {
            count++;
        } else {
            count = -1;
        }

        return count;
    }

    public static void main(String[] args) {
        RepeatedSubstringMatch s = new RepeatedSubstringMatch();

        //        System.out.println(s.repeatedStringMatch("abcd", "cdabcdab"));
        //        System.out.println(s.repeatedStringMatch("a", "aa"));
        System.out.println(s.repeatedStringMatch("abac", "abcabcabcabc"));
    }

}
