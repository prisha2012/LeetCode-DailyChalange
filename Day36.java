class Solution {
    static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> countByY = new HashMap<>();

        for (int[] p : points) {
            countByY.put(p[1], countByY.getOrDefault(p[1], 0L) + 1);
        }

        List<Long> pairs = new ArrayList<>();
        long totalPairs = 0;

        for (long cnt : countByY.values()) {
            if (cnt >= 2) {
                long c = cnt * (cnt - 1) / 2;
                pairs.add(c);
                totalPairs += c;
            }
        }

        long ans = 0;

        for (long c : pairs) {
            ans = (ans + (c % MOD) * ((totalPairs - c) % MOD)) % MOD;
        }

        ans = (ans * inv2()) % MOD;

        return (int) ans;
    }

    private long inv2() {
        return (MOD + 1) / 2;  
    }
}

public class Day36-3623 {
    
}
