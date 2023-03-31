package ruichen.pramp;

import java.util.HashSet;
import java.util.Set;

public class GettingADifferentNumber {
    // https://www.pramp.com/challenge/aK6V5GVZ9MSPqvG1vwQp

    class Solution1 {
        // TC = O(n + MAX_INT) = O(n)
        // SC = O(n)
        public int getDifferentNumber(int[] arr) {
            Set<Integer> seen = new HashSet<>();
            for (int num : arr) {
                seen.add(num);
            }
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (!seen.contains(i)) {
                    return i;
                }
            }
            return Integer.MAX_VALUE;
        }
    }

    class Solution2 {
        // We can use input array as a hash table to save space:
        // For each element, we make its index equal to its value via swaps.
        // Then we loop over arr again to find the first element that is not equal to its index.

        // TC = O(n + MAX_INT) = O(n): Every number is at most moved once, and we skip those already in their target indices while performing the swap, so the time complexity is linear despite the nested loop.
        // SC = O(1)
        public int getDifferentNumber(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                // Swap until we find an element that is out of range or already in its correct position
                while (arr[i] >= 0 && arr[i] < n && arr[i] != i && arr[i] != arr[arr[i]]) {
                    swap(arr, i, arr[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] != i) {
                    return i;
                }
            }
            return n;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
