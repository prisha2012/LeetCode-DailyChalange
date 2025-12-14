class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int seats = 0;
        long ways = 1;
        int plantsBetween = 0;

        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                seats++;
             
                if (seats > 2 && seats % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                }
                plantsBetween = 0;
            } else if (seats >= 2 && seats % 2 == 0) {
                plantsBetween++;
            }
        }

        return seats >= 2 && seats % 2 == 0 ? (int) ways : 0;
    }
}

public class Day48-2147 {
    
}
