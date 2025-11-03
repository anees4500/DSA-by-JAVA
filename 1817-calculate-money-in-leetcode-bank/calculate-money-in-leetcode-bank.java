 class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int week = 0;

        for (int i = 1; i <= n; i++) {
            // Monday → start of new week
            if (i % 7 == 1) {
                week++;
            }

            // Deposit = base (week start) + (day index in week)
            sum += week + (i - 1) % 7;
        }

        return sum;
    }
}
