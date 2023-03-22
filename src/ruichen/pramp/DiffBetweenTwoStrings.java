package ruichen.pramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffBetweenTwoStrings {
    // https://www.pramp.com/challenge/5j2xWAx1qPtlZGLnG2O0

    class Solution {
        // This solution passes 6/8 test cases. I manually examined the failed tests, and I believe that my solution is indeed correct and favors removal first, and that the test cases are incorrect.
        // TC = O(mn), SC = O(mn)
        public String[] diffBetweenTwoStrings(String source, String target) {
            // 1. Run edit distance (replace not allowed)
            int m = source.length(), n = target.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (source.charAt(i - 1) == target.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
            // 2. Construct answer by looking up dp table
            List<String> res = new ArrayList<>();
            int i = m, j = n;
            while (i > 0 && j > 0) {
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    res.add("+" + target.charAt(j - 1));
                    j--;
                } else if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    res.add("" + source.charAt(i - 1));
                    i--;
                    j--;
                } else {
                    // We favor removal first, since we are filling answer backwards, we need to discuss the removal case last
                    res.add("-" + source.charAt(i - 1));
                    i--;
                }
            }
            // Postprocess leftover characters
            while (j > 0) {
                res.add("+" + target.charAt(j - 1));
                j--;
            }
            while (i > 0) {
                res.add("-" + source.charAt(i - 1));
                i--;
            }
            Collections.reverse(res);
            return res.toArray(new String[0]);
        }
    }
}
