class Solution {
    static class Pair implements Comparable<Pair> {
        int freq, val;
        Pair(int f, int v) { freq = f; val = v; }
        public int compareTo(Pair o) {
            if (freq != o.freq) return freq - o.freq;
            return val - o.val;
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> cnt = new HashMap<>();
        TreeSet<Pair> elite = new TreeSet<>();
        TreeSet<Pair> waiting = new TreeSet<>();
        long s = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int old = cnt.getOrDefault(v, 0);
            if (old > 0) {
                Pair pOld = new Pair(old, v);
                if (elite.contains(pOld)) {
                    elite.remove(pOld);
                    s -= (long) pOld.freq * pOld.val;
                } else {
                    waiting.remove(pOld);
                }
            }
            int newFreq = old + 1;
            cnt.put(v, newFreq);
            Pair pNew = new Pair(newFreq, v);
            if (!elite.isEmpty() && pNew.compareTo(elite.first()) > 0) {
                elite.add(pNew);
                s += (long) pNew.freq * pNew.val;
            } else {
                waiting.add(pNew);
            }

            if (i >= k) {
                int out = nums[i - k];
                int oldOut = cnt.get(out);
                Pair pOut = new Pair(oldOut, out);
                if (elite.contains(pOut)) {
                    elite.remove(pOut);
                    s -= (long) pOut.freq * pOut.val;
                } else {
                    waiting.remove(pOut);
                }
                int newOut = oldOut - 1;
                if (newOut > 0) {
                    cnt.put(out, newOut);
                    Pair pOutNew = new Pair(newOut, out);
                    if (!elite.isEmpty() && pOutNew.compareTo(elite.first()) > 0) {
                        elite.add(pOutNew);
                        s += (long) pOutNew.freq * pOutNew.val;
                    } else {
                        waiting.add(pOutNew);
                    }
                } else {
                    cnt.remove(out);
                }
            }

            if (i >= k - 1) {
                while (elite.size() < x && !waiting.isEmpty()) {
                    Pair move = waiting.pollLast();
                    elite.add(move);
                    s += (long) move.freq * move.val;
                }
                while (elite.size() > x) {
                    Pair move = elite.pollFirst();
                    s -= (long) move.freq * move.val;
                    waiting.add(move);
                }

                if (cnt.size() < x) {
                    long sumWindow = 0;
                    for (int j = i - k + 1; j <= i; j++) sumWindow += nums[j];
                    ans[i - k + 1] = sumWindow;
                } else {
                    ans[i - k + 1] = s;
                }
            }
        }
        return ans;
    }
}

public class Day8-3321 {
    
}
