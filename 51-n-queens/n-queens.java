class Solution {

    public boolean isSafe(char[][] board, int row , int col, int n){
        // horizontal
        for(int j = 0; j<n; j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        // vertical

        for(int i = 0; i<n; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // left diagonal

        for(int i = row, j = col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i = row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        

        return true;
    }


    public void ans(char[][] board, int r, List<List<String>> ans){

        if(r>board.length-1){
            return;
        }

        
        for(int c = 0; c<board.length; c++){
            if(isSafe(board,r,c,board.length)){
                board[r][c] = 'Q';
                if(r==board.length-1){
                    print(board,ans);
                }
                ans(board,r+1, ans);
            }
            board[r][c]=  '.';
        }
    }


    public void print(char[][] board, List<List<String>> List){
        List<String> l = new ArrayList<>();
        for(int i = 0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<board.length; j++){
               sb.append(board[i][j]);
            }

            l.add(sb.toString());

        }

        List.add(new ArrayList<>(l));
    }



    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i = 0; i<board.length; i++){
            Arrays.fill(board[i],'.');
        }

        // for(int i = 0; i<n; i++){
        //     ans(board,0,ans);
        // }

        ans(board,0,ans);

        return ans;
    }
}