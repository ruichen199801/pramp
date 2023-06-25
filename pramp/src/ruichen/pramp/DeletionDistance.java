package ruichen.pramp;

public class DeletionDistance {
    // https://www.pramp.com/challenge/61ojWAjLJbhob2nP2q1O

    class Solution {
        // Edit distance without replacing
        // TC = O(m * n), SC = O(m * n)
        public int deletionDistance(String str1, String str2) {
            int m = str1.length(), n = str2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0) {
                        dp[0][j] = j;
                    } else if (j == 0) {
                        dp[i][0] = i;
                    } else {
                        if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // String index is different than dp index
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
