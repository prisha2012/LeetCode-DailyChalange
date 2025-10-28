class Solution {
    public int countValidSelections(int[] nums) {
        int total=0;
        for(int num:nums) total+=num;
        int leftsum=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(2*leftsum==total){count+=2;}
                else if(Math.abs(2 * leftsum - total) == 1){ count++;}

            }
            leftsum+=nums[i];
        }
        return count;

    }
}