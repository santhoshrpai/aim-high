package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajasan
 */
public class problem771 {

    public int numJewelsInStones(String J, String S) {

        if (S == null || J == null || J.isEmpty() || S.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < J.length(); i++) {
            m.put(J.charAt(i), 1);
        }

        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (m.containsKey(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }

}
