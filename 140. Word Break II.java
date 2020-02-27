// Not accepted flat BFS DP solution due to Time Limit Exceeded
public class Solution {

  public List<String> wordBreak(String s, List<String> wordDict) {
    Map<Integer, List<String>> cameFromPaths = new HashMap();
    for(int i = 0; i < s.length(); i++) {
      for (String word: wordDict) {
        if ((i == 0 || cameFromPaths.get(i) != null) && i + word.length() <= s.length()) {
          if (s.startsWith(word, i)) {
            List<String> paths = cameFromPaths.get(i + word.length());
            if (paths == null) {
              paths = new ArrayList();
              cameFromPaths.put(i + word.length(), paths);
            }
            if (i == 0) {
              paths.add(word);
            } else {
              for (String cameFromPath: cameFromPaths.get(i)) {
                paths.add(cameFromPath + " " + word);
              }
            }
          }
        }
      }
    }

    return cameFromPaths.getOrDefault(s.length(), new ArrayList());
  }
}

// Accepted DFS + memo DP solution
class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    return wordBreak(s, wordDict, new HashMap());
  }

  private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
    if (memo.containsKey(s)) return memo.get(s);
    List<String> result = new ArrayList();
    memo.put(s, result);

    for(String word: wordDict) {
      if (s.startsWith(word)) {
        if (s.length() == word.length()) {
          result.add(word);
        } else {
          List<String> tails = wordBreak(s.substring(word.length()), wordDict, memo);
          for(String tail: tails) {
            result.add(word + " " + tail);
          }
        }
      }
    }
    return result;
  }

}
