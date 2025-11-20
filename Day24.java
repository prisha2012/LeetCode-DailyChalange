import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));

        int a = -1, b = -1;  
        int count = 0;

        for (int[] it : intervals) {
            int l = it[0], r = it[1];

            if (l <= b) continue;

            if (l <= a) {
                count++;
                b = a;
                a = r;
            } 
         
            else {
                count += 2;
                b = r - 1;
                a = r;
            }
        }

        return count;
    }
}

public class Day24-757 {
    
}
