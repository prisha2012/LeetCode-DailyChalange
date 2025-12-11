class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> row = new HashMap<>();
        Map<Integer, int[]> col = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            row.putIfAbsent(x, new int[]{y, y});   
            col.putIfAbsent(y, new int[]{x, x});   

            row.get(x)[0] = Math.min(row.get(x)[0], y);
            row.get(x)[1] = Math.max(row.get(x)[1], y);

            col.get(y)[0] = Math.min(col.get(y)[0], x);
            col.get(y)[1] = Math.max(col.get(y)[1], x);
        }

        // 2. Count covered buildings
        int covered = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            int minY = row.get(x)[0], maxY = row.get(x)[1];
            int minX = col.get(y)[0], maxX = col.get(y)[1];

            if (minY < y && y < maxY && minX < x && x < maxX) {
                covered++;
            }
        }

        return covered;
    }
}

public class Day45-3531 {
    
}
