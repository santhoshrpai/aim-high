package interview.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajasan
 */
public class LongestAbsoluteFilePath {

    public static int lengthLongestPath(String input) {

        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] x = input.split("\n");

        Map<Integer, Integer> map = new HashMap<>();

        int val = 0;

        map.put(0, 0);

        for (int i = 0; i < x.length; i++) {

            int level = x[i].lastIndexOf("\t") + 1;
            int len = x[i].substring(level, x[i].length()).length();

            if (x[i].contains(".")) {
                int lenAtLevel = map.get(level) + len;
                val = Math.max(val, lenAtLevel);
            } else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }

        return val;

    }

    public static void main(String[] args) {

        String string = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        int val = lengthLongestPath(string);

        System.out.println(val);

    }

}
