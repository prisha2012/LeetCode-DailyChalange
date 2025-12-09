import java.util.*;

class Solution {
    public long countSpecialTriplets(int[] nums) {
        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();

        // initialize right map with frequencies
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        long ans = 0;

        for (int j = 0; j < nums.length; j++) {
            int mid = nums[j];

            // remove current mid from right map (it becomes center)
            right.put(mid, right.get(mid) - 1);
            if (right.get(mid) == 0) right.remove(mid);

            // iterate over all possible k values on right
            for (int k : right.keySet()) {
                long countK = right.get(k);

                int neededI = 2 * mid - k;

                if (left.containsKey(neededI)) {
                    ans += left.get(neededI) * countK;
                }
            }

            // add mid to left for future iterations
            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }

        return ans;
    }
}

public class Day43-3583 {
    
}
