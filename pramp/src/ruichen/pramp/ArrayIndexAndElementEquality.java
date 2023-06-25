package ruichen.pramp;

public class ArrayIndexAndElementEquality {
    // https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjz04

    class Solution {
        // Binary search: TC = O(log n), SC = O(1)
        public int indexEqualsValueSearch(int[] arr) {
            if (arr == null || arr.length == 0) {
                return -1;
            }

            int left = 0, right = arr.length - 1;
            int minIndex = Integer.MAX_VALUE;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == mid) {
                    minIndex = Math.min(minIndex, mid);
                    right = mid - 1;
                } else if (arr[mid] > mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
        }
    }
}
