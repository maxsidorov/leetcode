class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int N = board.length, M = board[0].length;
        for (int i = 0; i < N; i++) {
            markAsUnsurrounded(board, i, 0);
            markAsUnsurrounded(board, i, M - 1);
        }
        for (int j = 1; j < M - 1; j++) {
            markAsUnsurrounded(board, 0, j);
            markAsUnsurrounded(board, N - 1, j);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = board[i][j] == 'U' ? 'O' : 'X';
            }
        }
    }
    
    private void markAsUnsurrounded(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        if (board[i][j] == 'O') {
            board[i][j] = 'U';
            markAsUnsurrounded(board, i + 1, j);
            markAsUnsurrounded(board, i - 1, j);
            markAsUnsurrounded(board, i, j + 1);
            markAsUnsurrounded(board, i, j - 1);
        }
    }
}
