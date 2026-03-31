// class Solution {


//     public boolean isSame(String str1, String str2,   char[]  ans , int i , int m){

//         StringBuilder sb = new StringBuilder();

//         for(int k = i; k<i+m;  k++){
//             sb.append(ans[k]);
//         }

//         return sb.toString()==str2;
//     }


//     public String generateString(String str1, String str2) {
        

//         int n = str1.length();
//         int m = str2.length();

//         int N = n + m -1;

//         char ans[] = new char[N];

//         Arrays.fill(ans,'$');

//         boolean canChange[] = new boolean[N];

//         Arrays.fill(canChange,true);

//         // fill if T with str1

//         for(int i = 0; i<str1.length(); i++){
            
//             if(str1.charAt(i)=='T' ){
                
//                 if(canChange[i] || ans[i]==str2.charAt(0)){
//                     int idx = 0;
//                     for(int j = i ; j<m +i; j++ ){

//                         if(ans[idx] != '$' && ans[idx] != str2.charAt(j)) {
//                             return "";
//                         }

//                         ans[j] = str2.charAt(idx);
//                         canChange[j] = false;
//                         idx++;

//                     }
                    
//                 }
//                 else{
//                     return "";
//                 }


//             }


//         }


//         // remaining fill with a

//         for(int i = 0; i<N; i++){
//             if(ans[i]=='$'){
//                 ans[i] = 'a';
//             }
//         }

//         // check for F

//         for(int i= 0; i<n; i++){
//             if(str1.charAt(i)=='F'){
//                 if(isSame(str1,str2,ans,i,m)){
//                     boolean changed = false;

//                     for (int k = i + m - 1; k >= i; k--) {
//                         if (canChange[k]) {
//                             ans[k] = 'b';  // minimal change
//                             canChange[k] = false;
//                             changed = true;
//                             break;
//                         }
//                     }

//                     if (!changed) return "";
                
//                 }
//             }
//         }

//         return new String(ans);
//     }
// }


class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;

        char[] word = new char[N];
        boolean[] canChange = new boolean[N];

        // Fill with placeholder
        for (int i = 0; i < N; i++) {
            word[i] = '$';
        }

        // Step 1: Process 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                int idx = i;
                for (int j = 0; j < m; j++) {
                    if (word[idx] != '$' && word[idx] != str2.charAt(j)) {
                        return "";
                    }
                    word[idx] = str2.charAt(j);
                    idx++;
                }
            }
        }

        // Step 2: Fill remaining with 'a'
        for (int i = 0; i < N; i++) {
            if (word[i] == '$') {
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        // Step 3: Process 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                if (isSame(word, str2, i, m)) {
                    boolean changed = false;

                    for (int k = i + m - 1; k >= i; k--) {
                        if (canChange[k]) {
                            word[k] = 'b';  // minimal change
                            canChange[k] = false;
                            changed = true;
                            break;
                        }
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }
}