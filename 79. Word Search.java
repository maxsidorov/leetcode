class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (tryWord(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    public boolean tryWord(char[][] board, String word, int index, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
            if (board[i][j] == word.charAt(index)) {
                if (index == word.length() - 1) {
                    return true;
                } else {
                    char ch = board[i][j];
                    board[i][j] = 0;
                    boolean result = tryWord(board, word, index + 1, i + 1, j)
                        || tryWord(board, word, index + 1, i - 1, j)
                        || tryWord(board, word, index + 1, i, j + 1)
                        || tryWord(board, word, index + 1, i, j - 1);
                    board[i][j] = ch;
                    return result;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
