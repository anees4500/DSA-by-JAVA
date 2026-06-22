class Solution {
    public int maxNumberOfBalloons(String text) {

        int n = text.length();

        int arr[] = new int[26];

        String maskt = "balloon";

        for(int i = 0;i<n; i++){
            arr[text.charAt(i)-'a']++;

        }

        int min  = Integer.MAX_VALUE;

        for(int i = 0; i<maskt.length(); i++){
            char ch = maskt.charAt(i);
            if(ch=='o' ||  ch=='l'){
                min = Math.min(min , arr[ch-'a']/2);
            }
            min = Math.min(min, arr[maskt.charAt(i)-'a']);
        }

        return min;

    }
}