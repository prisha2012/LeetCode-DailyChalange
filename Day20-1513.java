class Solution {
    public int numSub(String s) {
        long res = 0, count = 0, mod = 1000000007;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
            else {
                res = (res + count * (count + 1) / 2) % mod;
                count = 0;
            }
        }
        res = (res + count * (count + 1) / 2) % mod;
        return (int) res;
    }
}

public class Day20-1513 {
    
}
