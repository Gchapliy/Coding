package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(String.format("aim: %s, res: %s", 3,lengthOfLongestSubstring("abcabcbb")));
        System.out.println(String.format("aim: %s, res: %s", 1, lengthOfLongestSubstring("bbbbb")));
        System.out.println(String.format("aim: %s, res: %s", 3, lengthOfLongestSubstring("pwwkew")));
        System.out.println(String.format("aim: %s, res: %s", 0, lengthOfLongestSubstring("")));
        System.out.println(String.format("aim: %s, res: %s", 1, lengthOfLongestSubstring(" ")));
        System.out.println(String.format("aim: %s, res: %s", 2, lengthOfLongestSubstring("au")));
        System.out.println(String.format("aim: %s, res: %s", 3, lengthOfLongestSubstring("dvdf")));
    }
}
