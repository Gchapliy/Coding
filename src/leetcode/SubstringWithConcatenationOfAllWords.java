package leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("a", new String[]{"a"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.isEmpty() || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Integer> r = new ArrayList<>();
        int sLen = s.length();
        int num = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < sLen - num * wordLen + 1; i++) {
            String sub = s.substring(i, i + num * wordLen);
            if (isConcat(sub, counts, wordLen)) {
                r.add(i);
            }
        }
        return r;
    }

    /**
     * */
    private static boolean isConcat(String sub, Map<String, Integer> counts, int wordLen) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i += wordLen) {
            String sWord = sub.substring(i, i + wordLen);
            seen.put(sWord, seen.getOrDefault(sWord, 0) + 1);
        }
        return seen.equals(counts);
    }
}
