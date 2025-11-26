class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 1_000_000_007;
        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int val = grid[i][j];

                for (int r = 0; r < k; r++) {

                    
                    if (i > 0 && dp[i-1][j][r] > 0) {
                        int newMod = (r + val) % k;
                        dp[i][j][newMod] = (dp[i][j][newMod] + dp[i-1][j][r]) % MOD;
                    }

                   
                    if (j > 0 && dp[i][j-1][r] > 0) {
                        int newMod = (r + val) % k;
                        dp[i][j][newMod] = (dp[i][j][newMod] + dp[i][j-1][r]) % MOD;
                    }
                }
            }
        }
        return dp[n-1][m-1][0];
    }
}

public class Day30-2435 {
    
}
