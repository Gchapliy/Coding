package leetcode;

public class RegularExpressionMatching {
    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("mississippi", "mis*is*ip*."));
//        System.out.println(isMatch("aaa", "ab*a*c*a"));
//        System.out.println(isMatch("aaca", "ab*a*c*a"));
//        System.out.println(isMatch("aaba", "ab*a*c*a"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);

                if (pChar == '.' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[m][n];
    }

    static void deepPrint(boolean[][] dp, int step) {
        System.out.println("Step: " + step);
        for (boolean[] outer : dp) {
            System.out.print("[");
            for (boolean inner : outer) {
                System.out.printf("%s ", inner);
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
