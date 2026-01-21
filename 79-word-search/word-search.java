class Solution {

    public boolean helper(char[][] board, int k , int i , int j , String word){
        if(k==word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>= board[0].length){
            return false;
        }
        if(board[i][j]!=word.charAt(k)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = helper(board, k+1, i+1, j, word) ||
                        helper(board, k+1, i, j+1, word) ||
                        helper(board, k+1, i-1 , j, word) ||
                        helper(board, k+1, i, j-1, word);

        board[i][j] = temp;
        return found;                

    }
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(helper(board,0,i,j, word)){
                    return true;
                }
            }
        }

        
        return false;
    }
}