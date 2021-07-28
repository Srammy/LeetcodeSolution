class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        int n = matrix.length;
        // 先沿着主对角线翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 在每一行中，以中间的数为轴，进行翻转
        int midIndex = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < midIndex; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}