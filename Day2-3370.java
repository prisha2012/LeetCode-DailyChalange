class Solution {
    public int smallestNumber(int n) {
        int bitlen=32-Integer.numberOfLeadingZeros(n);
        return (1<<bitlen)-1;
    }
}
public class Day2-3370 {
    
}
