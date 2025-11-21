class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int ans = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {

            int left = -1, right = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    left = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == ch) {
                    right = i;
                    break;
                }
            }
            if (left != -1 && right != -1 && right - left >= 2) {
                boolean[] middle = new boolean[26];
                for (int i = left + 1; i < right; i++) {
                    middle[s.charAt(i) - 'a'] = true;
                }
                for (boolean b : middle) {
                    if (b) ans++;
                }
            }
        }

        return ans;
    }
}

public class Day25-1930 {
    
