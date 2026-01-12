class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        for (int i = 0; i < points.length - 1; i++) {
            total += Math.max(
                Math.abs(points[i+1][0] - points[i][0]),
                Math.abs(points[i+1][1] - points[i][1])
            );
        }
        return total;
    }
}

public class Day77 {
    
}
