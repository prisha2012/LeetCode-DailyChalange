import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hGap = maxConsecutive(hBars) + 1;
        int vGap = maxConsecutive(vBars) + 1;

        int side = Math.min(hGap, vGap);
        return side * side;
    }

    private int maxConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        int max = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}

public class DAY 80 {
    
}
