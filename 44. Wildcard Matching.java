class Solution {
  public boolean isMatch(String s, String p) {
    return isMatchImpl(s, 0, p, 0, new Boolean[s.length() + 1][p.length() + 1]);
  }

  private boolean isMatchImpl(String s, int sIndex, String p, int pIndex, Boolean[][] memo) {
    if (memo[sIndex][pIndex] != null) return memo[sIndex][pIndex];
    if (sIndex == s.length() && pIndex == p.length()) return memo[sIndex][pIndex] = true;
    if (pIndex == p.length()) return memo[sIndex][pIndex] = false;
    char pChar = p.charAt(pIndex);
    if (pChar == '*') {
      while (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') pIndex++;
      for (int i = sIndex; i < s.length() + 1; i++) {
        if (isMatchImpl(s, i, p, pIndex + 1, memo)) return memo[sIndex][pIndex] = true;
      }
    } else if (sIndex < s.length() && pChar == '?') {
      return memo[sIndex][pIndex] = isMatchImpl(s, sIndex + 1, p, pIndex + 1, memo);
    } else if (sIndex < s.length() && pChar == s.charAt(sIndex))  {
      return memo[sIndex][pIndex] = isMatchImpl(s, sIndex + 1, p, pIndex + 1, memo);
    }
    return memo[sIndex][pIndex] = false;
  }
}
