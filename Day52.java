class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long base = 0;

        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        int half = k / 2;

        long[] prefVal = new long[n + 1];
        long[] prefPrice = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefVal[i + 1] = prefVal[i] + (long) strategy[i] * prices[i];
            prefPrice[i + 1] = prefPrice[i] + prices[i];
        }

        long maxDelta = 0;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long oldFirst = prefVal[mid] - prefVal[l];
            long delta1 = -oldFirst;

            long oldSecond = prefVal[r] - prefVal[mid];
            long newSecond = prefPrice[r] - prefPrice[mid];
            long delta2 = newSecond - oldSecond;

            long delta = delta1 + delta2;
            maxDelta = Math.max(maxDelta, delta);
        }

        return base + maxDelta;
    }
}
