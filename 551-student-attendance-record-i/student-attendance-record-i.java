 class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'A') {
                countA++;
                if (countA >= 2) return false;
                countL = 0; // reset L count
            } 
            else if (ch == 'L') {
                countL++;
                if (countL >= 3) return false;
            } 
            else { // 'P'
                countL = 0; // reset L count
            }
        }

        return true;
    }
}
