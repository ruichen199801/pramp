package ruichen.pramp;

import java.util.Arrays;

public class AbsoluteValueSort {
    // https://www.pramp.com/challenge/4E4NW7NjbnHQEx1AxoXE

    class Solution1 {
        // Custom sort
        // TC = O(n log n), SC = O(n)
        public int[] absSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return arr;
            }

            // Comparator in Java only works with object
            int n = arr.length;
            Integer[] intArr = new Integer[n];
            for (int i = 0; i < n; i++) {
                intArr[i] = arr[i];
            }

            Arrays.sort(intArr, (a, b) -> {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                }
                return Math.abs(a) - Math.abs(b);
            });

            // Cast back
            for (int i = 0; i < n; i++) {
                arr[i] = intArr[i];
            }
            return arr;
        }
    }

    class Solution2 {
        // Selection sort (if we want constant space)
        // TC = O(n^2), SC = O(1)
        public int[] absSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return arr;
            }
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (smaller(arr[j], arr[min])) {
                        min = j;
                    }
                }
                swap(arr, i, min);
            }
            return arr;
        }

        private boolean smaller(int a, int b) {
            if (Math.abs(a) == Math.abs(b)) {
                return a < b;
            }
            return Math.abs(a) < Math.abs(b);
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
