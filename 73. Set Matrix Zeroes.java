class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        boolean isFirstColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        //if (true) return;
        // System.out.println("isFirstColumnZero = " + isFirstColumnZero);
        
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    // System.out.println("i = " + i + ", j = " + j + ", matrix[0][j] = " + matrix[0][j] + ", matrix[i][0] = " + matrix[i][0]);
                    matrix[i][j] = 0;
                }
            }
            if (isFirstColumnZero) {
                matrix[i][0] = 0;
            }
        }
    }
}
