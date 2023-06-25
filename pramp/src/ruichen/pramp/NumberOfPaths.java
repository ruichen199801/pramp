package ruichen.pramp;

public class NumberOfPaths {
    // https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoY7X

    class Solution {
        // TC = O(n^2), SC = O(n^2)
        public int numOfPathsToDest(int n) {
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        grid[i][j] = 1;
                    } else if (i == j) {
                        grid[i][j] = grid[i - 1][j]; // Only upper half is valid path
                    } else {
                        grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                    }
                }
            }
            return grid[n - 1][n - 1];
        }
    }
}
