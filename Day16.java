class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ones=0;
        for(int x:nums) if(x==1)ones++;
        if(ones>0)return n-ones;

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int g=nums[i];
            if(g==1){
                min=0;
                break;
            }
            for(int j=i+1;j<n;++j){
                g=gcd(g,nums[j]);
                if(g==1){
                min=Math.min(min,j-i);
                break;
                }
            }
        }
          return min == Integer.MAX_VALUE ? -1 : min + n - 1;
    }
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
public class Day16-2654 {
    
}
