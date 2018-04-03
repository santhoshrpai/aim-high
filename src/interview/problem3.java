package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rajasan
 */
public class problem3 {

    //    public static int lengthOfLongestSubstring(String s) {
    //
    //        if (s == null || s.isEmpty()) {
    //            return 0;
    //        }
    //
    //        Set<Character> set = new HashSet<>(s.length());
    //
    //        int count = 0;
    //        int max = count;
    //        for (int i = 0; i < s.length(); i++) {
    //            for (int j = i; j < s.length(); j++) {
    //                if (set.contains(s.charAt(j))) {
    //                    if (count > max) {
    //                        max = count;
    //                    }
    //                    count = 0;
    //                    set.clear();
    //                    break;
    //                } else {
    //                    set.add(s.charAt(j));
    //                    count++;
    //                }
    //            }
    //        }
    //
    //        return count > max ? count : max;
    //    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>(s.length());

        int max = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                if (j - i > max) {
                    max = j - i;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
