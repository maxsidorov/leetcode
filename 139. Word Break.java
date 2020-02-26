class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean reached[] = new boolean[s.length() + 1];
    reached[0] = true;
    for (int i = 0; i < s.length(); i++) {
      if (reached[i]) {
        for (String word: wordDict) {
          if (i + word.length() <= s.length() && !reached[i + word.length()]) {
            boolean matched = true;
            for(int j = 0; j < word.length(); j++) {
              if (s.charAt(i + j) != word.charAt(j)) {
                matched = false;
                break;
              }
            }
            reached[i + word.length()] = matched;
          }
        }
      }
    }
    return reached[s.length()];
  }
}
