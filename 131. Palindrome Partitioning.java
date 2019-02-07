class Solution {
  public List<List<String>> partition(String s) {
    if (s == null && s.length() == 0) {
      return new ArrayList();
    } else {
      return partitionImpl(s, 0, s.length() - 1, new List[s.length()][s.length()]);
    }
  }

  private List<List<String>> partitionImpl(String s, int left, int right, List[][] memo) {
    if (memo[left][right] != null) {
      return (List<List<String>>)memo[left][right];
    }
    
    List<List<String>> result = new ArrayList();
    if (left == right) {
      List<String> item = new ArrayList();
      item.add(s.substring(left, right + 1));
      result.add(item);
      return result;
    }
    for (int i = left; i <= right; i++) {
      if (isPalindrome(s, left, i)) {
        String leftPalindrome = s.substring(left, i + 1);
        if (i == right) {
          List<String> item = new ArrayList();
          item.add(leftPalindrome);
          result.add(item);
        } else {
          List<List<String>> rightPalindromesList = partitionImpl(s, i + 1, right, memo);
          for (List<String> rightPalindromes: rightPalindromesList) {
            List<String> item = new ArrayList();
            item.add(leftPalindrome);
            item.addAll(rightPalindromes);
            result.add(item);
          }
        }
      }
    }
    memo[left][right] = (List)result;
    return result;
  }

  private boolean isPalindrome(String s, int left, int right) {
    int len = (right - left + 1) / 2;
    for (int i = 0; i < len; i++) {
      if (s.charAt(left + i) != s.charAt(right - i)) {
        return false;
      }
    }
    return true;
  }

}
