class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = getNeighborsCount(board, i, j);
                System.out.println(neighbors);
                if ((board[i][j] == 1 && (neighbors == 2 || neighbors == 3))
                   || (board[i][j] == 0 && neighbors == 3)) {
                        
                    board[i][j] = board[i][j] | 2;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
        
    }
    
    private int getNeighborsCount(int[][] board, int k, int l) {
        int count = 0;
        for (int i = k - 1; i <= k + 1; i++) {
            for (int j = l - 1; j <= l + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    if (i != k || j != l) {
                        count += board[i][j] & 1;
                    }
                }
            }
        }
        return count;
    }
}
