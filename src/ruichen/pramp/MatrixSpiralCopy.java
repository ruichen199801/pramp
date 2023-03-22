package ruichen.pramp;

public class MatrixSpiralCopy {
    // https://www.pramp.com/challenge/ml9AwEA42YHK735G3lq5

    class Solution {
        // Iterative solution: TC = O(mn), SC = O(mn)
        public int[] spiralCopy(int[][] inputMatrix) {
            int m = inputMatrix.length, n = inputMatrix[0].length;
            int[] res = new int[m * n];
            int index = 0;
            int up = 0, down = m - 1, left = 0, right = n - 1;

            while (up <= down && left <= right) {
                for (int i = left; i <= right; i++) {
                    res[index++] = inputMatrix[up][i];
                }
                up++;

                for (int i = up; i <= down; i++) {
                    res[index++] = inputMatrix[i][right];
                }
                right--;

                if (up <= down) {
                    for (int i = right; i >= left; i--) {
                        res[index++] = inputMatrix[down][i];
                    }
                }
                down--;

                if (left <= right) {
                    for (int i = down; i >= up; i--) {
                        res[index++] = inputMatrix[i][left];
                    }
                }
                left++;
            }

            return res;
        }
    }
}
