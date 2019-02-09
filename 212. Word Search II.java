class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList();
    Set<String> uniqueWords = Arrays.stream(words).collect(Collectors.toSet());
    for (String word: uniqueWords) {
      boolean isFound = false;
      for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
          if (!isFound && tryFind(board, i, j, word, 0)) {
            result.add(word);
            isFound = true;
          }
        }
      }
    }
    return result;
  }
  
  private boolean tryFind(char[][] board, int i, int j, String word, int wordIndex) {
    if (wordIndex >= word.length()) {
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
       || board[i][j] != word.charAt(wordIndex)) {
      return false;
    }
    board[i][j] = Character.toUpperCase(board[i][j]);

    try {
      return tryFind(board, i - 1, j, word, wordIndex + 1)
        || tryFind(board, i + 1, j, word, wordIndex + 1)
        || tryFind(board, i, j + 1, word, wordIndex + 1)
        || tryFind(board, i, j - 1, word, wordIndex + 1);
    } finally {
      board[i][j] = Character.toLowerCase(board[i][j]);
    }
  }
}
