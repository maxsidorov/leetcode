class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return uniquePathsHelper(m, n, 0, 0, memo);
    }
    
    private int uniquePathsHelper(int m, int n, int i, int j, Integer[][] memo) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i > m - 1 || j > n - 1) return 0;
        if (memo[i][j] != null) return memo[i][j];
        int result =  uniquePathsHelper(m, n, i + 1, j, memo) + uniquePathsHelper(m, n, i, j + 1, memo);
        memo[i][j] = Integer.valueOf(result);
        return result;
    }
}
