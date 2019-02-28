class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList();
    Set<String> wordSet = new HashSet(wordList);
    Map<String, Set<String>> backLinksMap = new HashMap();
    Map<String, Integer> backLinksLevelMap = new HashMap();
    LinkedList<Node> queue = new LinkedList();
    int maxLevel = Integer.MAX_VALUE;
    queue.add(new Node(beginWord, 0));
    while (!queue.isEmpty()) {
      Node wordNode = queue.poll();

      if (wordNode.level > maxLevel) {
        break;
      }

      if (wordNode.word.equals(endWord)) {
        if (maxLevel == Integer.MAX_VALUE) {
          maxLevel = wordNode.level;
        }
        buildResult(result, backLinksMap, wordNode.word, new LinkedList());
        return result;
      }
      List<String> nextWords = getNextWords(wordSet, wordNode.word);
      for (String nextWord: nextWords) {
        Integer backLinksLevel = backLinksLevelMap.get(nextWord);
        if (backLinksLevel == null || backLinksLevel == wordNode.level + 1) {
          Set<String> backLinks = backLinksMap.get(nextWord);
          if (backLinks == null) {
            backLinks = new HashSet();
            backLinksMap.put(nextWord, backLinks);
            backLinksLevelMap.put(nextWord, wordNode.level + 1);
          }
          backLinks.add(wordNode.word);
          if (maxLevel == Integer.MAX_VALUE) {
            queue.add(new Node(nextWord, wordNode.level + 1));
          }
        }
      }
      wordSet.remove(wordNode.word);
    }
    return result;
  }

  private List<String> getNextWords(Set<String> wordSet, String word) {
    List<String> nextWords = new ArrayList();
    StringBuilder wordBuilder = new StringBuilder(word);
    for(int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      for (char rep = 'a'; rep <= 'z'; rep++) {
        if (rep != ch) {
          wordBuilder.setCharAt(i, rep);
          String nextWord = wordBuilder.toString();
          if (wordSet.contains(nextWord)) {
            nextWords.add(nextWord);
          }
        }
      }
      wordBuilder.setCharAt(i, ch);
    }
    return nextWords;
  }

  private void buildResult(List<List<String>> result, Map<String, Set<String>> backLinksMap, String word, LinkedList<String> path) {
    path.addFirst(word);
    Set<String> backLinks = backLinksMap.get(word);
    if (backLinks != null) {
      for (String backLink: backLinks) {
        buildResult(result, backLinksMap, backLink, path);
      }
    } else {
      result.add(new ArrayList(path));
    }
    path.removeFirst();
  }

  private static class Node {
    String word;
    int level;

    Node(String word, int level) {
      this.word = word;
      this.level = level;
    }
  }
}
