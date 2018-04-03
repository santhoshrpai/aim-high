package interview.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author rajasan
 */
public class StringChain {

    static int longestChain(String[] words) {

        if (words == null || words.length == 0 || words.length > 50000) {
            return 0;
        }

        Set<String> givenWords = new HashSet<>(words.length);
        Map<String, Integer> wordToCount = new HashMap<>();

        for (String word : words) {
            givenWords.add(word);
        }

        int maxCount = 0;
        for (String word : words) {
            if (word.length() == 0 || word.length() > 60 || word.length() < maxCount) {
                continue;
            }
            int count = countChain(givenWords, word, wordToCount) + 1;
            wordToCount.put(word, count);

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;

    }

    public static int countChain(Set<String> words, String s, Map<String, Integer> wordToCount) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;

        for (int pos = 0; pos < s.length(); pos++) {
            String nextWord = s.substring(0, pos).concat(s.substring(pos + 1));

            if (words.contains(nextWord)) {
                if (wordToCount.containsKey(nextWord)) {
                    if (count < wordToCount.get(nextWord)) {
                        count = wordToCount.get(nextWord);
                    }
                } else {
                    int countNext = countChain(words, nextWord, wordToCount);
                    if (count < (countNext + 1)) {
                        count = countNext + 1;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] words = {
                "an", "a", "and", "bearyt", "anda"
        };

        // "beary", "bear", "bea", "be"

        String[] words1 = {
                "a",
                "zxb",
                "ba",
                "bca",
                "bda",
                "bdca",
                "zxbe",
                "azxbe",
                "azxpbe"
        };

        String[] words2 = {
                "a",
                "b",
                "ba",
                "bca",
                "bda",
                "bdca"
        };
        System.out.println(longestChain(words));

    }
}
