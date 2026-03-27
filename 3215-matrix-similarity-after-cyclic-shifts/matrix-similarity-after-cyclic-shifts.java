class Solution {

    public boolean areSimilar(int[][] mat, int k) {

        int n = mat[0].length;
        k = k % n;

        for(int i = 0; i < mat.length; i++){

            for(int j = 0; j < n; j++){

                int newCol;

                if(i % 2 == 0){
                    newCol = (j + k) % n; // left shift
                } else {
                    newCol = (j - k + n) % n; // right shift
                }

                if(mat[i][j] != mat[i][newCol]){
                    return false;
                }
            }
        }

        return true;
    }
}