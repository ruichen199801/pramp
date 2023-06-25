package ruichen.pramp;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringOfAllCharacters {
    // https://www.pramp.com/challenge/wqNo9joKG6IJm67B6z34

    class Solution {
        // Sliding window: expand the right bound, once we find a valid substring that contains all characters,
        // update min, and start contracting the left bound, stop when it's no longer valid.

        // TC = O(m + n), SC = O(m + n)

        // xyz
        // xyyzyzyx
        //          j
        //       i

        // targetCount: x1 y1 z1
        // charCount: x1 y4 z2
        // minLen: 3
        // start:  5

        // return zyx
        public String getShortestUniqueSubstring(char[] arr, String str) {
            Map<Character, Integer> targetCount = new HashMap<>();
            for (char c : arr) {
                targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> charCount = new HashMap<>();
            int minLen = Integer.MAX_VALUE;
            int start = 0;
            int i = 0; // i: leftBound, j: rightBound

            for (int j = 0; j < str.length(); j++) {
                char rightChar = str.charAt(j);
                charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

                while (containsAllCharacters(charCount, targetCount)) {
                    int currLen = j - i + 1;
                    if (currLen < minLen) {
                        minLen = currLen;
                        start = i;
                    }

                    char leftChar = str.charAt(i);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);
                    i++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : str.substring(start, start + minLen);
        }

        private boolean containsAllCharacters(Map<Character, Integer> charCount, Map<Character, Integer> targetCount) {
            for (Map.Entry<Character, Integer> entry : targetCount.entrySet()) {
                if (charCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }
}
