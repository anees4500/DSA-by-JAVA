 import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();

        // Convert HH:MM to total minutes
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            minutes.add(hour * 60 + min);
        }

        // Sort times
        Collections.sort(minutes);

        int minDiff = Integer.MAX_VALUE;

        // Compare consecutive times
        for (int i = 1; i < minutes.size(); i++) {
            minDiff = Math.min(minDiff, minutes.get(i) - minutes.get(i - 1));
        }

        // Check circular difference (last to first)
        int first = minutes.get(0);
        int last = minutes.get(minutes.size() - 1);
        minDiff = Math.min(minDiff, 1440 - (last - first));

        return minDiff;
    }
}
