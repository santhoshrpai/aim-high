package interview;

import java.util.Stack;

/**
 * @author rajasan
 */
public class problem20 {

    public static boolean isValid(String s) {

        if (s.isEmpty()) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> t = new Stack<>();

        int cCount = 0;
        int bCount = 0;
        int sCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '{':
                t.push(c);
                break;
            case '(':
                t.push(c);
                break;
            case '[':
                t.push(c);
                break;
            default:

            }
        }

        if (cCount == 0 && bCount == 0 && sCount == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("())[]{}"));
    }

}
