package ruichen.pramp;

public class DecodeVariations {
    // https://www.pramp.com/challenge/r1Kw0vwG6OhK9AEGAy6L

    class Solution {
        // TC = O(n), SC = O(n) (can be optimized to O(1))
        public int decodeVariations(String S) {
            int n = S.length();
            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = S.charAt(0) == '0' ? 0 : 1;

            for (int i = 2; i <= n; i++) {
                int oneDigit = Integer.parseInt(S.substring(i - 1, i));
                if (oneDigit > 0) {
                    dp[i] += dp[i - 1];
                }

                int twoDigits = Integer.parseInt(S.substring(i - 2, i));
                if (10 <= twoDigits && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            return dp[n];
        }
    }
}
