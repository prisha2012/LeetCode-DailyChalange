class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;

        // Compute total area and search bounds
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            totalArea += (double) l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double half = totalArea / 2.0;

        // Binary search on y
        for (int i = 0; i < 60; i++) { // enough for 1e-5 precision
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] sq : squares) {
                double bottom = sq[1];
                double len = sq[2];

                if (mid > bottom) {
                    double height = Math.min(len, mid - bottom);
                    areaBelow += height * len;
                }
            }

            if (areaBelow < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
public class Day78 {
    
}
