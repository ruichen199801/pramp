package ruichen.pramp;

public class DecryptMessage {
    // https://www.pramp.com/challenge/8noLWxLP6JUZJ2bA2rnx

    class Solution {
        // The trick is to find the relations between the previous decrypted letter and the current encrypted one.
        // enc[n] = dec[n] + secondStep[n-1] - 26m
        // -> dec[n] = enc[n] - secondStep[n-1] + 26m
        // TC = O(n), SC = O(n) (to store output)
        public String decrypt(String word) {
            int secondStep = 1; // 100 - 1 = 99, array flattened to variable
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int newAscii = word.charAt(i);
                newAscii -= secondStep;
                while (newAscii < 'a') {
                    newAscii += 26;
                }
                res.append((char) newAscii);
                secondStep += newAscii;
            }
            return res.toString();
        }
    }
}
