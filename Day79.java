import java.util.*;

class Solution {
    static class SegmentTree {
        int n;
        long[] length;   
        int[] count;     
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            length = new long[4 * n];
            count = new int[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else {
                if (l + 1 == r) {
                    length[node] = 0;
                } else {
                    length[node] = length[node * 2] + length[node * 2 + 1];
                }
            }
        }

        long totalCovered() {
            return length[1];
        }
    }

    static class Event {
        long y;
        int x1, x2;
        int type;

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        TreeSet<Long> xSet = new TreeSet<>();

        // Step 1: Create events
        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            xSet.add(x);
            xSet.add(x + l);

            events.add(new Event(y, 0, 0, +1));
            events.add(new Event(y + l, 0, 0, -1));
        }

        // Step 2: Coordinate compression
        long[] xs = new long[xSet.size()];
        int idx = 0;
        for (long v : xSet) xs[idx++] = v;

        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            xIndex.put(xs[i], i);
        }

        // Fill x indices
        idx = 0;
        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.set(idx++, new Event(y,
                    xIndex.get(x),
                    xIndex.get(x + l),
                    +1));
            events.set(idx++, new Event(y + l,
                    xIndex.get(x),
                    xIndex.get(x + l),
                    -1));
        }

        // Step 3: Sort events by y
        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        // Step 4: Sweep & record prefix areas
        List<Long> ys = new ArrayList<>();
        List<Double> areaPrefix = new ArrayList<>();

        long prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            long currY = e.y;
            long coveredX = st.totalCovered();
            area += coveredX * (currY - prevY);

            ys.add(currY);
            areaPrefix.add(area);

            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = currY;
        }

        double totalArea = area;
        double target = totalArea / 2.0;

        // Step 5: Binary search for y
        for (int i = 1; i < ys.size(); i++) {
            if (areaPrefix.get(i) >= target) {
                double prevArea = areaPrefix.get(i - 1);
                long dy = ys.get(i) - ys.get(i - 1);
                long coveredX = (long) ((areaPrefix.get(i) - prevArea) / dy);

                double remaining = target - prevArea;
                return ys.get(i - 1) + remaining / coveredX;
            }
        }

        return ys.get(ys.size() - 1);
    }
}

public class Day79 {
    
}
