class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int[] zeros = new int[n];
        int zc = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') zeros[zc++] = i;
        long run = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') run++;
            else {
                ans += run * (run + 1) / 2;
                run = 0;
            }
        }
        ans += run * (run + 1) / 2;
        if (zc == 0) return (int) ans;
        for (int z = 1; z + z * (long) z <= n; z++) {
            if (zc < z) break;
            for (int k = 0; k + z - 1 < zc; k++) {
                int leftZero = zeros[k];
                int rightZero = zeros[k + z - 1];
                int prevZero = k - 1 >= 0 ? zeros[k - 1] : -1;
                int nextZero = (k + z) < zc ? zeros[k + z] : n;
                int sMin = prevZero + 1;
                int sMax = leftZero;
                int neededLen = z * z + z;
                for (int start = sMin; start <= sMax; start++) {
                    int eReq = start + neededLen - 1;
                    int eLower = Math.max(eReq, rightZero);
                    int validEnds = Math.max(0, nextZero - eLower);
                    if (validEnds == 0) {
                        if (eReq > nextZero - 1 && rightZero <= nextZero - 1) break;
                        continue;
                    }
                    ans += validEnds;
                }
            }
        }
        return (int) ans;
    }
}

public class Day19-3234 {
    
}
