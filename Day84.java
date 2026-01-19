class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(pre, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[][] pre, int k, int threshold) {
        for (int i = 0; i + k < pre.length; i++) {
            for (int j = 0; j + k < pre[0].length; j++) {
                int sum = pre[i + k][j + k]
                        - pre[i][j + k]
                        - pre[i + k][j]
                        + pre[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}

public class Day84 {
    
}
