class Solution {
    public int compress(char[] chars) {
        int i = 0; 
        int j = 0;

        while(i<chars.length){
            char ch = chars[i];
            int count = 0;
            while(i<chars.length && ch == chars[i]){
                count++;
                i++;

            }

            chars[j++] = ch;

            if(count>1){
                 for(char c : Integer.toString(count).toCharArray()){
                    chars[j++] = c;
                 }
            }
        }
        return j;

    }
}