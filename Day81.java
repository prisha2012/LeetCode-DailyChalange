import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> horizontal = getDistances(hFences, m);
        Set<Integer> vertical = getDistances(vFences, n);

        long maxSide = 0;
        for (int h : horizontal) {
            if (vertical.contains(h)) {
                maxSide = Math.max(maxSide, h);
            }
        }

        if (maxSide == 0) return -1;
        return (int)((maxSide * maxSide) % MOD);
    }

    private Set<Integer> getDistances(int[] fences, int limit) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(limit);

        for (int f : fences) list.add(f);

        Collections.sort(list);

        Set<Integer> dist = new HashSet<>();
        int size = list.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                dist.add(list.get(j) - list.get(i));
            }
        }
        return dist;
    }
}

public class Day81 {
    
}
