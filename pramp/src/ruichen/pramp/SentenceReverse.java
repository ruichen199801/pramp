package ruichen.pramp;

public class SentenceReverse {
    // https://www.pramp.com/challenge/VKdqbrq6B1S5XAyGAOn4

    class Solution {
        // Assume no leading or trailing space, words are separated by only one space
        // TC = O(n), SC = O(1)
        public char[] reverseWords(char[] arr) {
            if (arr == null || arr.length <= 1) {
                return arr;
            }
            // 1. Reverse the whole array
            reverse(arr, 0, arr.length - 1);
            // 2. Reverse each of the words
            int start = 0;
            for (int i = 0; i < arr.length; i++) {
                // Find start of a word
                if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
                    start = i;
                }
                // Find end of a word
                if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
                    reverse(arr, start, i);
                }
            }
            return arr;
        }

        private void reverse(char[] arr, int i, int j) {
            while (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
