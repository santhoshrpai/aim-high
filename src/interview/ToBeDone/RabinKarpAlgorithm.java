package interview.ToBeDone;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajasan
 */
public class RabinKarpAlgorithm {

    private Map<Character, Integer> characterToAsciiMap;

    private int primeNumber;

    RabinKarpAlgorithm() {
        characterToAsciiMap = new HashMap<>(26);
        primeNumber = 101;
        initialize();
    }

    public void initialize() {
        for (int i = 97; i < (97 + 26); i++) {
            characterToAsciiMap.put((char) i, i);
        }
    }

    public boolean findSubstring(String s, String subString) {
        if (s == null || subString == null) {
            return false;
        }

        int hashValue = getHash(subString);
        int len = subString.length();

        for (int i = 0; i < s.length() - len; i++) {
            int newHash = getHash(s.substring(i, len));
            if (newHash == hashValue && s.substring(i, len).equals(subString)) {
                return true;
            }
        }

        return false;
    }

    // Rabin Karp algorithm

    // hash function
    // f(a) = asciiValue * primeNumber ^ pos
    public int getHash(String s) {
        int hashValue = 0;
        for (int i = 0; i < s.length(); i++) {
            hashValue += characterToAsciiMap.get(s.charAt(i)) * Math.pow(primeNumber, i);
        }
        return hashValue;
    }

    public static void main(String[] args) {
        String s = "ababrsanthosh";
        String s1 = "antho";
        RabinKarpAlgorithm a = new RabinKarpAlgorithm();

        System.out.println(a.findSubstring(s, s1));
    }
}
