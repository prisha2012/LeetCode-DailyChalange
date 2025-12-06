class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minDQ = new ArrayDeque<>();
        Deque<Integer> maxDQ = new ArrayDeque<>();

        int left = 1; 

        for (int right = 1; right <= n; right++) {
            int val = nums[right - 1];

            // Maintain max deque (decreasing)
            while (!maxDQ.isEmpty() && maxDQ.peekLast() < val)
                maxDQ.pollLast();
            maxDQ.addLast(val);

            // Maintain min deque (increasing)
            while (!minDQ.isEmpty() && minDQ.peekLast() > val)
                minDQ.pollLast();
            minDQ.addLast(val);

            // Shrink window while invalid
            while (!maxDQ.isEmpty() && !minDQ.isEmpty()
                    && maxDQ.peekFirst() - minDQ.peekFirst() > k) {

                int removeVal = nums[left - 1];

                if (maxDQ.peekFirst() == removeVal)
                    maxDQ.pollFirst();
                if (minDQ.peekFirst() == removeVal)
                    minDQ.pollFirst();

                left++;
            }

            // Now [left..right] is the largest valid window
            if (left >= 2) {
                dp[right] = (prefix[right - 1] - prefix[left - 2] + MOD) % MOD;
            } else {
                dp[right] = prefix[right - 1];
            }

            prefix[right] = (prefix[right - 1] + dp[right]) % MOD;
        }

        return (int) dp[n];
    }
}

public class Day40-3323 {
    
}
