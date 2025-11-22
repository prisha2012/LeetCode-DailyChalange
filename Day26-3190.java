class Solution {
    public int minimumOperations(int[] nums) {
        int total = 0;
        for (int x : nums) {
            int mod = x % 3;
            if (mod != 0) {
                total += Math.min(mod, 3 - mod);
            }
        }
        return total;
    }
}

public class Day26-3190 {
    
}
