 class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.trim();
        String[] words = s.split("\\s+");

        for (String str : words) {
            for (int i = str.length() - 1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }

         
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
