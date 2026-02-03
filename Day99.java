class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<3)return false;
        int i=1;
        int count=0;
      while(i<n&&nums[i]>nums[i-1]) i++;
      if(i==1||i==n)return false;
      while(i<n&&nums[i]<nums[i-1])i++;
      if(i==n) return false;
      while(i<n&&nums[i]>nums[i-1]) i++;
       
      return i==n; 
    }
}
public class Day99 {
    
}
