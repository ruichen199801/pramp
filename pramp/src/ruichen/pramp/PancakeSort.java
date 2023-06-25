package ruichen.pramp;

public class PancakeSort {
    class Solution {
        // arr = [1, 5, 4, 3, 2]
        // 1. curMax = 5
        // 2. [5, 1, 4, 3, 2]
        //    [2, 3, 4, 1, 5]
        // 3. ...

        // Tweaked selection sort:
        // 1. Find curMax among all 5 elements (5)
        // 2. Flip first k elements up to curMax, then flip the whole 5 elements to place 5 to last position
        // 3. Repeat step 1+2 to find and flip-flip curMax for the remaining 4,3,2,1 elements

        // TC = O(n^2), SC = O(1)
        public int[] pancakeSort(int[] arr) {
            for (int i = arr.length - 1; i >= 0; i--) {
                int maxIndex = findMax(arr, i);
                flip(arr, maxIndex + 1);
                flip(arr, i + 1);
            }
            return arr;
        }

        private int findMax(int[] arr, int k) {
            int maxIndex = 0;
            for (int i = 1; i <= k; i++) {
                if (arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }

        private void flip(int[] arr, int k) {
            int l = 0, r = l + k - 1;
            while (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
