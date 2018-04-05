class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int level = 0; level < matrix.length / 2; level++) {
            for (int i = level; i < matrix.length - level - 1; i++) {
                temp = matrix[level][i];
                matrix[level][i] = matrix[matrix.length - i - 1][level];
                matrix[matrix.length - i - 1][level] = matrix[matrix.length - level - 1][matrix.length - i - 1];
                matrix[matrix.length - level - 1][matrix.length - i - 1] = matrix[i][matrix.length - level - 1];
                matrix[i][matrix.length - level - 1] = temp;
            }
        }
    }
}
