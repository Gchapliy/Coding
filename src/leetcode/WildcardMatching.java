package leetcode;

public class WildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("cb", "?a")); // false
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 0; j < p.length(); ++j) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j];
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(p.charAt(j) == '*') {
                    final boolean matchEmpty = dp[i + 1][j];
                    final boolean matchSome = dp[i][j + 1];
                    dp[i + 1][j + 1] = matchEmpty || matchSome;
                } else if (isMatch(s, i, p, j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }

        return dp[m][n];
    }
    private static boolean isMatch(final String s, int i, final String p, int j) {
        return j >= 0 && p.charAt(j) == '?' || s.charAt(i) == p.charAt(j);
    }
}
