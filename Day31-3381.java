class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE);
        long prefix = 0;
        long ans = Long.MIN_VALUE;
        minPref[0] = 0; 
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int r = (i + 1) % k;
            if (minPref[r] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - minPref[r]);
            }
            minPref[r] = Math.min(minPref[r], prefix);
        }
        return ans;
    }
}
