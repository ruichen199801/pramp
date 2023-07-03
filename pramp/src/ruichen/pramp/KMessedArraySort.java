package ruichen.pramp;

import java.util.PriorityQueue;

public class KMessedArraySort {
    // https://www.pramp.com/challenge/XdMZJgZoAnFXqwjJwnBZ

    class Solution1 {
        // Insertion sort
        // TC = O(n * k) (only works well for small k), SC = O(1)
        public int[] sortKMessedArray(int[] arr, int k) {
            //  Walk through the example array to see how insertion works: [5, 2, 8, 12, 1, 6]
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }

                arr[j + 1] = key;
            }
            return arr;
        }
    }

    class Solution2 {
        // Sliding window + heap sort
        // TC = O(n * log k), SC = O(k)
        public int[] sortKMessedArray(int[] arr, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // Initialize a window size of k+1 for arr[0]
            for (int i = 0; i <= k; i++) {
                minHeap.offer(arr[i]);
            }

            // Pop the min and set it as the next sorted element, and slide the window to arr[1],arr[2],...
            int index = 0;
            for (int i = k + 1; i < arr.length; i++) {
                arr[index++] = minHeap.poll();
                minHeap.offer(arr[i]);
            }

            // Continue popping the min from the heap until it is empty
            while (!minHeap.isEmpty()) {
                arr[index++] = minHeap.poll();
            }

            return arr;
        }
    }
}
