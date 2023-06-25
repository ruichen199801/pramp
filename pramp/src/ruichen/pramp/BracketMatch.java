package ruichen.pramp;

public class BracketMatch {
    // https://www.pramp.com/challenge/xJZA01AxdlfpM2vZ2Wwa

    class Solution {
        // TC = O(n), SC = O(1)
        public int bracketMatch(String text) {
            int left = 0, right = 0;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    if (left > 0) {
                        left--;
                    } else {
                        right++;
                    }
                }
            }
            return left + right;
        }
    }
}
