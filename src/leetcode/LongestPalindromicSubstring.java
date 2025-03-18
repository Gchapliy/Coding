package leetcode;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String pal1 = getPalindrome(s, i, i);
            String pal2 = getPalindrome(s, i, i + 1);

            if(pal1.length() > res.length())
                res = pal1;
            if(pal2.length() > res.length())
                res = pal2;
        }

        return res;
    }

    private static String getPalindrome(String s, int pos1, int pos2) {
        while (pos1 >= 0 && pos2 < s.length() && s.charAt(pos1) == s.charAt(pos2)) {
            pos1--;
            pos2++;
        }

        return s.substring(pos1 + 1, pos2);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
