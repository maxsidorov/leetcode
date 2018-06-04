class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                count++;
                resetCircle(M, i);
            }
        }
        return count;
    }
    
    private void resetCircle(int[][] M, int i) {
        if (M[i][i] == 1) {
            M[i][i] = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    resetCircle(M, j);
                }
            }
        }
    }
    
}
