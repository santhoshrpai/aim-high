package interview.stack;

import java.util.Stack;

/**
 * @author rajasan
 */
public class ValidParentheses {

    //    (', ')', '{', '}', '[' and ']

    public static boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char last = stack.pop();

                if ((c == ')' && last != '(') || (c == '}' && last != '{') || (c == ']' && last != '[')) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

}
