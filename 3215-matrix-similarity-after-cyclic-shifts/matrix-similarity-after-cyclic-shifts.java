class Solution {


    public void leftRot(int[][] mat , int row){

         int first = mat[row][0];
        for(int i = 0; i<mat[0].length-1; i++){
            mat[row][i] = mat[row][i+1];
        }
        mat[row][mat[0].length-1] = first;
       
    }

    public void rightRot(int[][] mat, int row){

        int first = mat[row][mat[0].length-1];
        for(int i = mat[0].length-1; i>0; i--){
            mat[row][i] = mat[row][i-1];
        }

        mat[row][0] = first;
       
    }

    public boolean areSimilar(int[][] mat, int k) {

        int mask[][] = new int[mat.length][mat[0].length];

        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                mask[i][j] = mat[i][j];
            }
        }

        
        for(int i = 0; i<k; i++){

            for(int j = 0; j<mat.length; j++){
                if(j%2==0){
                    leftRot(mat,j);
                }
                else{
                    rightRot(mat,j);
                }
            }
        }

        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mask[i][j] != mat[i][j]){
                    return false;
                }
            }
        }

        return true;


    }
}