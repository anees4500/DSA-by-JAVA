class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int dp[][] = new int[n][n];

        if(s.length()==1){
            return s;
        }

        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            }
            else{
                return s.substring(0,1);
            }
        }

        for(int i = 0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int i = 0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = 1;
            }
        }

        // for(int i = 0; i<n-1; i++){
        //     for(int j = i+2; j<n; j++){
        //         if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
        //             dp[i][j] = 1;
        //         }
        //     }
        // }

        for(int k = 2; k<n; k++){
            for(int i = 0; i<n-k; i++){
                int j = i+k;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();


        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(dp[i][j] == 1){

                    if(sb.length()<(j - i +1)){
                        sb = new StringBuilder();
                        sb.append(s.substring(i,j+1));
                    }

                }
            }
        }

        return sb.toString();

    }
}