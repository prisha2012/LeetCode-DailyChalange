class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}

public class Day23-2154 {
    
}
