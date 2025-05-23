package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = Map.of(
                "2", List.of("a", "b", "c"),
                "3", List.of("d", "e", "f"),
                "4", List.of("g", "h", "i"),
                "5", List.of("j", "k", "l"),
                "6", List.of("m", "n", "o"),
                "7", List.of("p", "q", "r", "s"),
                "8", List.of("t", "u", "v"),
                "9", List.of("w", "x", "y", "z")
        );
        String[] s = digits.split("");

        for (int i = 0; i < s.length; i++) {
            List<String> letters = map.get(s[i]);
            if (res.isEmpty() && letters != null) {
                res.addAll(letters);
            } else {
                res = res.stream()
                        .map(l -> letters.stream()
                                .map(l::concat)
                                .toList())
                        .flatMap(List::stream)
                        .toList();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }
}
