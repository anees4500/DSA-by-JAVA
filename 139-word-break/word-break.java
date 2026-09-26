class Solution {

    Boolean dp[][];
    public boolean help(String s , int i , int j ,  List<String> wordDict){

        if(j==s.length()){
            return dp[i][j] = wordDict.contains(s.substring(i,j));
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        String sub = s.substring(i,j);


        if(wordDict.contains(sub)){
            return dp[i][j] = help(s,j,j , wordDict) || help(s,i,j+1 , wordDict);
        }

        return dp[i][j] = help(s,i,j+1 , wordDict);

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        

        dp = new Boolean[s.length() +1][s.length()+1];

         return help(s,0,0,wordDict);
    }
}