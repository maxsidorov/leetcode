// My solution
class Solution {
  public int numDecodings(String s) {
    return numDecodingsImpl(s, 0);
  }

  private int numDecodingsImpl(String s, int i) {
    if (i >= s.length()) return 1;
    if (s.charAt(i) == '0') return 0;
    int result = numDecodingsImpl(s, i + 1);
    if (i + 1 < s.length() && 
            (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
      result += numDecodingsImpl(s, i + 2);
    }
    return result;

  }
}

// My DP solution
class Solution {
  public int numDecodings(String s) {
    if (s.charAt(0) == '0') return 0;
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != '0') {
        dp[i + 1] = dp[i];
      }
      if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
        dp[i + 1] += dp[i - 1];
      }
    }
    return dp[s.length()];
  }
}
