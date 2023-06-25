package ruichen.pramp;

public class BasicRegexParser {
    // https://www.pramp.com/challenge/KvZ3aL35Ezc5K9Eq9Llp

    class Solution {
        /*
        Different from Leetcode, "*" now only matches 0 or more immediately preceding character(s).

        Sub-problem: dp[i][j] - Whether the first i characters in text match the first j characters in pattern.

        Base case:
            1. dp[0][0] = true
            2. dp[i][0] = false: text is not null, pattern is null
            3. dp[0][j] = dp[0][j-2] , if pattern[j-1] = '*'
                        = false      , otherwise

        Recursive equation:
        if pattern[j-1] == text[i-1] or '.',
            dp[i][j] = dp[i-1][j-1]
        elif pattern[j-1] == '*',
            dp[i][j] = dp[i][j-2] ||         // '*' matches 0 occurrence
                        (dp[i-1][j] &&       // '*' matches 1 or more occurrences
                        (pattern[j-2] == text[i-1] || pattern[j-2] == '.'))
        else,
            dp[i][j] = false

        Answer: dp[m][n]

        TC = O(m * n), SC = O(m * n)
        */
        public boolean isMatch(String text, String pattern) {
            int m = text.length(), n = pattern.length();
            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;

            for (int j = 2; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char t = text.charAt(i - 1), p = pattern.charAt(j - 1);
                    if (p == t || p == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p == '*') {
                        dp[i][j] = dp[i][j - 2] ||
                                // [acd ac*d] or [acd a.*d]: match c
                                // acd:  c - i-1
                                // ac*d: * - j-1, c - j-2
                                (dp[i - 1][j] && (pattern.charAt(j - 2) == t || pattern.charAt(j - 2) == '.'));
                    }
                }
            }

            return dp[m][n];
        }
    }
}
