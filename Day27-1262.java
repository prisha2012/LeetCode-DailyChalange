class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) r1.add(n);
            else if (n % 3 == 2) r2.add(n);
        }
        Collections.sort(r1);
        Collections.sort(r2);

        if (sum % 3 == 0) return sum;

        int rem = sum % 3;
        int ans = 0;

        if (rem == 1) {
            int remove1 = r1.size() > 0 ? r1.get(0) : Integer.MAX_VALUE;
            int remove2 = r2.size() > 1 ? r2.get(0) + r2.get(1) : Integer.MAX_VALUE;
            ans = sum - Math.min(remove1, remove2);
        } else { 
            int remove1 = r2.size() > 0 ? r2.get(0) : Integer.MAX_VALUE;
            int remove2 = r1.size() > 1 ? r1.get(0) + r1.get(1) : Integer.MAX_VALUE;
            ans = sum - Math.min(remove1, remove2);
        }

        return ans < 0 ? 0 : ans;
    }
}

public class Day27-1262 {
    
}
