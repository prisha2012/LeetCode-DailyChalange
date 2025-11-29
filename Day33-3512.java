class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int x : nums) sum += x;

        long rem = sum % k;
        if (rem == 0) return 0;

        return (int) rem;   
    }
}

public class Day3512 {
    
}
