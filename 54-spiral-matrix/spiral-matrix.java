import java.util.*;

class Solution {
    
    public void helper(int[][] mat, int i, int j, int n, int m, List<Integer> answer){
 
        for(int k = j; k < m; k++){
            answer.add(mat[i][k]);
        }

       
        for(int k = i + 1; k < n; k++){
            answer.add(mat[k][m - 1]);
        }

        
        if(i < n - 1){
            for(int k = m - 2; k >= j; k--){
                answer.add(mat[n - 1][k]);
            }
        }

         
        if(j < m - 1){
            for(int k = n - 2; k > i; k--){
                answer.add(mat[k][j]);
            }
        }
    }
         
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();

        int n = matrix.length;        
        int m = matrix[0].length;     

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            helper(matrix, i, j, n, m, answer);
            i++;
            j++;
            n--;
            m--;
        }

        return answer;
    }
}
