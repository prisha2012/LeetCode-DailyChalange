class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        for(int num:nums){
            if(s.contains(num)) return num;
            s.add(num);
        }
        return -1;
    }
}
public class Day67 {
    
}
