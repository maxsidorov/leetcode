// It doesn't work!!! Need to debug
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMatrixImpl(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
    
    private boolean searchMatrixImpl(int[][] matrix, int target, int left, int right, int top, int bottom) {
        System.out.println("left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
        if (left > right || top > bottom) return false;
        int midH = (left + right)/2, midV = (top + bottom)/2;
        if (matrix[midH][midV] == target) return true;
        //if (left == right && top == bottom) return false;
        return searchMatrixImpl(matrix, target, left, midH, midV, bottom)
            || searchMatrixImpl(matrix, target, midH, right, top, midV)
            || (matrix[midH][midV] > target
                ? searchMatrixImpl(matrix, target, left, midH - 1, top, midV - 1)
                : searchMatrixImpl(matrix, target, midH + 1, right, midV + 1, bottom));
    }
}

// O(N+M)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length -1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
