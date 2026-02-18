class Solution {
    public String removeOccurrences(String s, String part) {

        while(s.contains(part)) {

            char[][] arr = new char[2][s.length()];

            for(int i = 0; i < s.length(); i++){
                arr[0][i] = '1';
                arr[1][i] = s.charAt(i);
            }

            for(int i = 0; i <= s.length() - part.length(); i++){

                StringBuilder sb = new StringBuilder();

                for(int j = i; j < i + part.length(); j++){
                    sb.append(s.charAt(j));
                }

                if(sb.toString().equals(part)){
                    for(int j = i; j < i + part.length(); j++){
                        arr[0][j] = '0';
                    }
                    break;  
                }
            }

            StringBuilder sb2 = new StringBuilder();

            for(int i = 0; i < s.length(); i++){
                if(arr[0][i] == '1'){
                    sb2.append(arr[1][i]);
                }
            }

            s = sb2.toString();
        }

        return s;
    }
}
