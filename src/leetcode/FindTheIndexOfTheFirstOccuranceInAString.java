package leetcode;

public class FindTheIndexOfTheFirstOccuranceInAString {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }
    public static int strStr(String haystack, String needle) {
        int res = -1;

        int[][] memo = new int[needle.length() + 1][haystack.length() + 1];
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for (int i = 0; i <= haystack.length(); i++) {
            memo[0][i] = 1;
        }

        for (int i = 1; i <= n.length; i++) {
            for (int j = 1; j <= h.length; j++) {
                memo[i][j] = n[i-1] == h[j-1] ? memo[i-1][j-1] + 1: memo[i-1][j];
                if(memo[i][j] == n.length + 1) {
                    res = j - n.length;
                    break;
                }
            }
        }

        return res;
    }
}
