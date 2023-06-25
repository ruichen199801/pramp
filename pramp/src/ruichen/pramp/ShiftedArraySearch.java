package ruichen.pramp;

public class ShiftedArraySearch {
    // https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoYPX

    class Solution {
        // Step 1: Tweaked binary search to find pivot point
        // Step 2: Classic binary search on one of the two sorted halves
        // TC = O(log n), SC = O(1)
        public int shiftedArrSearch(int[] shiftArr, int num) {
            // [9, 12, 17, 2, 4, 5], num = 2
            //             p
            //  x
            int pivot = findPivot(shiftArr);

            // Tricky part is to compare target with arr[0] instead of arr[p] to reduce search space.
            if (pivot == 0 || num < shiftArr[0]) { // Handle 0 edge case
                return binarySearch(shiftArr, pivot, shiftArr.length - 1, num);
            } else {
                return binarySearch(shiftArr, 0, pivot - 1, num);
            }
        }

        private int findPivot(int[] shiftArr) {
            int left = 0, right = shiftArr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid == 0 || shiftArr[mid] < shiftArr[mid - 1]) { // Handle 0 edge case
                    return mid;
                } else if (shiftArr[mid] > shiftArr[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return 0; // Not shifted
        }

        private int binarySearch(int[] arr, int left, int right, int target) {
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
