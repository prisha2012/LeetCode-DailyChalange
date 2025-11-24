class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int num = 0;

        for (int bit : nums) {
            num = (num * 2 + bit) % 5;   
            ans.add(num == 0);
        }

        return ans;
    }
}

public class Day28-1018 {
    
}
