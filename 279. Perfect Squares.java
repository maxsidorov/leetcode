class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int min = i;
      int step = 2;
      while (step * step <= i) {
        min = Math.min(min, dp[i - step * step] + 1);
        step++;
      }
      dp[i] = min;
    }
    return dp[n];
  }
}
