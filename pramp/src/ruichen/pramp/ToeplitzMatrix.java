package ruichen.pramp;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {
    // https://www.pramp.com/challenge/0QmxM9x81lTKO47p43Jr

    class Solution1 {
        // Hash map: check if each element has the same diagonal hash r - c
        // TC = O(r * c), SC = O(r + c)
        public boolean isToeplitz(int[][] arr) {
            Map<Integer, Integer> seen = new HashMap<>(); // <r-c, value>
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!seen.containsKey(i - j)) {
                        seen.put(i - j, arr[i][j]);
                    } else {
                        if (seen.get(i - j) != arr[i][j]) {
                            return false; // Check if arr[1][2] and arr[2][3] have the same value
                        }
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        // Iterate over each diagonal to check manually
        // TC = O(r * c), SC = O(1)
        public boolean isToeplitz(int[][] arr) {
            int m = arr.length, n = arr[0].length;

            // Check the upper triangle, starting from first row
            for (int i = 0; i < n; i++) {
                int start = arr[0][i];
                int curr = i + 1;
                for (int j = 1; j < m; j++) {
                    if (curr < n && arr[j][curr] != start) {
                        return false;
                    }
                    curr++;
                }
            }

            // Check the lower triangle, starting from last row
            for (int i = n - 1; i >= 0; i--) {
                int start = arr[m - 1][i];
                int curr = i - 1;
                for (int j = m - 2; j >= 0; j--) {
                    if (curr >= 0 && arr[j][curr] != start) {
                        return false;
                    }
                    curr--;
                }
            }

            return true;
        }
    }
}
