class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        // Center must be 5
        if (g[r+1][c+1] != 5) return false;

        boolean[] seen = new boolean[10];

        // Check numbers 1–9 appear exactly once
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = g[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        // Check rows, columns, diagonals
        return
            g[r][c] + g[r][c+1] + g[r][c+2] == 15 &&
            g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] == 15 &&
            g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] == 15 &&

            g[r][c] + g[r+1][c] + g[r+2][c] == 15 &&
            g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] == 15 &&
            g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] == 15 &&

            g[r][c] + g[r+1][c+1] + g[r+2][c+2] == 15 &&
            g[r][c+2] + g[r+1][c+1] + g[r+2][c] == 15;
    }
}

public class Day64 {
    
}
