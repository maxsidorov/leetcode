class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!set.add(ch + " seen in row " + i)
                        || !set.add(ch + " seen in column " + j)
                        || !set.add(ch + " seen in cube " + i / 3 + "," + j / 3)) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}
