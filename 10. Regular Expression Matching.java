class Solution {
  public boolean isMatch(String s, String p) {
    return isMatch(s, 0, p, 0);
  }

  private boolean isMatch(String s, int sIndex, String p, int pIndex) {
    if (pIndex == p.length()) return sIndex == s.length();
    if (sIndex < s.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.')
      && isMatch(s, sIndex + 1, p, pIndex + 1))
      return true;
    if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
      if (sIndex < s.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.')
        && isMatch(s, sIndex + 1, p, pIndex))
        return true;
      return isMatch(s, sIndex, p, pIndex + 2);
    }
    return false;
  }
}
