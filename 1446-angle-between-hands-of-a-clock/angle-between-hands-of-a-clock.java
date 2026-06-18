class Solution {
    public double angleClock(int hour, int minutes) {
        
        double degree = Math.abs(30*hour - 5.5*minutes);

        degree = Math.min(degree, 360 - degree);

        return degree;
    }
}