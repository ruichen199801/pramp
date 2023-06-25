package ruichen.pramp;

import java.util.ArrayList;
import java.util.List;

public class FindTheDuplicates {
    // https://www.pramp.com/challenge/15oxrQx6LjtQj9JK9XlA

    class Solution1 {
        // Two pointers (when two arrays have roughly equal size)
        // TC = O(m + n), SC = O(n), n <= m (to hold the duplicates array)
        public int[] findDuplicates(int[] arr1, int[] arr2) {
            List<Integer> arr = new ArrayList<>();
            int m = arr1.length, n = arr2.length;
            int i = 0, j = 0;

            while (i < m && j < n) {
                if (arr1[i] == arr2[j]) {
                    arr.add(arr1[i]);
                    i++;
                    j++;
                } else if (arr1[i] > arr2[j]) {
                    j++;
                } else {
                    i++;
                }
            }

            int[] res = new int[arr.size()];
            for (int k = 0; k < arr.size(); k++) {
                res[k] = arr.get(k);
            }

            return res;
        }
    }

    class Solution2 {
        // Binary search (when one array is substantially longer than the other)
        // TC = O(n * log m), SC = O(n), n <= m (to hold the duplicates array)
        public int[] findDuplicates(int[] arr1, int[] arr2) {
            List<Integer> arr = new ArrayList<>();
            int m = arr1.length, n = arr2.length;

            // Assume m >> n: iterate over the smaller array, search each value in the larger array
            for (int i = 0; i < n; i++) {
                if (binarySearch(arr1, arr2[i]) != -1) {
                    arr.add(arr2[i]);
                }
            }

            int[] res = new int[arr.size()];
            for (int k = 0; k < arr.size(); k++) {
                res[k] = arr.get(k);
            }

            return res;
        }

        private int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
