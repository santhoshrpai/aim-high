package interview.dp;

import java.util.Stack;

/**
 * @author rajasan
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j = j + 2) {
                if (checkParentheses(s.substring(i, j))) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;

    }

    public static boolean checkParentheses(String s) {
        System.out.println(s);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static int longestParenthesesDP(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] len = new int[s.length() + 1];

        len[0] = 0;
        int max = len[0];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                len[i + 1] = 0;
            } else {
                if (i > 0) {
                    if (s.charAt(i - 1) == '(') {
                        len[i + 1] = len[i - 1] + 2;
                    } else {
                        if (i - len[i] - 1 > 0 && s.charAt(i - len[i] - 1) == '(') {
                            System.out.println(i + 1 - len[i] - 2);
                            len[i + 1] = len[i] + len[i + 1 - len[i] - 2] + 2;
                        } else {
                            len[i + 1] = 0;
                        }
                    }
                } else {
                    len[i + 1] = 0;
                }

                max = Math.max(max, len[i + 1]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestParenthesesDP(
                "()(((((((((())"));
    }
}
