import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.add(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            // Free rooms that are done before current meeting starts
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.add(new long[]{end, room});
            } else {
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + (end - start);
                count[(int) earliest[1]]++;
                busy.add(new long[]{newEnd, earliest[1]});
            }
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}

public class Day61 {
    
}
