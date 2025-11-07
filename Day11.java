class Solution {
    public long maxPower(int[] nums, int r, int k) {
        int n=nums.length;
        long[] prefix=new long[n+1];

        for(int i=0;i<n;i++){
            int left=Math.max(0,i-r);
            int right=Math.min(n-1,i+r);
            prefix[left]+=nums[i];
            if(right+1<n) prefix[right+1]-=nums[i];
        }
        for(int i=1;i<n;i++){
            prefix[i]+=prefix[i-1];

        }
        long maxP=k;
        for(int num:nums)maxP+=num;
        long left=0,right=maxP;
        while(left<right){
            long mid=(left+right)/2;
            if(isPossible(prefix,mid+1,k,r)) left=mid+1;
            else right=mid;
        }
        return left;
    }
    private boolean isPossible(long[] prefix,long minPower,long k,int r){
        int n=prefix.length;
        long[] diff=new long[n+1];
        for(int i=0;i<n-1;i++){
            if(i>0)diff[i]+=diff[i-1];
            long current=prefix[i]+diff[i];
            long need=Math.max(0,minPower-current);

            if(need==0)continue;
            if(need>k)return false;
            k-=need;
            diff[i]+=need;
            int end=Math.min(n-1,i+2*r+1);
            diff[end]-=need;
        }
        return true;
    }
}
public class Day11-2528 {
    
}
