class Solution {

    public boolean helper(char[][] board, int i, int j,
                      String word, int k) {

        if(k == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '/';

        boolean found = false;

        // Down
        if(i + 1 < board.length &&
        board[i + 1][j] != '/' &&
        board[i + 1][j] == word.charAt(k + 1)) {

            found |= helper(board, i + 1, j, word, k + 1);
        }

        // Up
        if(i - 1 >= 0 &&
        board[i - 1][j] != '/' &&
        board[i - 1][j] == word.charAt(k + 1)) {

            found |= helper(board, i - 1, j, word, k + 1);
        }

        // Right
        if(j + 1 < board[0].length &&
        board[i][j + 1] != '/' &&
        board[i][j + 1] == word.charAt(k + 1)) {

            found |= helper(board, i, j + 1, word, k + 1);
        }

        // Left
        if(j - 1 >= 0 &&
        board[i][j - 1] != '/' &&
        board[i][j - 1] == word.charAt(k + 1)) {

            found |= helper(board, i, j - 1, word, k + 1);
        }

        board[i][j] = temp;

        return found;
    }


    public boolean exist(char[][] board, String word) {
        

        int n = board.length; 
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){

                if(board[i][j]!='/' && board[i][j]==word.charAt(0)){

                    boolean ans = false;
                    ans = helper(board, i , j ,word ,  0);

                    if(ans==true){
                        return true;
                    }

                }
            }
        }

        return false;
    }
}