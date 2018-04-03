package interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rajasan
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> m = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String c = new String(s);
            if (m.containsKey(c)) {
                List<String> x = m.get(c);
                x.add(strs[i]);
                m.put(c, x);
            } else {
                List<String> x = new ArrayList<>();
                x.add(strs[i]);
                m.put(new String(c), x);
            }
        }

        List<List<String>> x = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : m.entrySet()) {
            x.add(entry.getValue());
        }

        return x;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

}
