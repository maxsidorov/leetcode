class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, longestIncreasingPathImpl(matrix, memo, i, j));
            }
        }
        return max;
    }
    
    public int longestIncreasingPathImpl(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] > 0) return memo[i][j];
        int max = 1;
        // look at right
        if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
            max = Math.max(max, 1 + longestIncreasingPathImpl(matrix, memo, i, j + 1));
        }
        // look at left
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            max = Math.max(max, 1 + longestIncreasingPathImpl(matrix, memo, i, j - 1));
        }
        // look to down
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            max = Math.max(max, 1 + longestIncreasingPathImpl(matrix, memo, i - 1, j));
        }
        // look to up
        if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
            max = Math.max(max, 1 + longestIncreasingPathImpl(matrix, memo, i + 1, j));
        }
        memo[i][j] = max;
        return max;
    }
}
