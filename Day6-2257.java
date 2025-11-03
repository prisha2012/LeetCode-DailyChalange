class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 2;
        }
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for (int[] g : guards) {
            for (int[] dir : directions) {
                int r = g[0] + dir[0];
                int c = g[1] + dir[1];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] < 2) {
                    grid[r][c] = 1;  
                    r += dir[0];
                    c += dir[1];
                }
            }
        }
        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguarded++;
                }
            }
        }

        return unguarded;
    }
}
public class Day6-22 {
    
}
