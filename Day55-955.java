class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();

        boolean[] vis=new boolean[n-1];
        int delc=0;
         for (int col = 0; col < m; col++) {
            boolean del = false;
        for(int i=0;i<n-1;i++){
            if(!vis[i]&&strs[i].charAt(col) > strs[i + 1].charAt(col)){
                del=true;
                break;
            }
        }
        if(del) delc++;

         
          else {
                for (int i = 0; i < n - 1; i++) {
                    if (!vis[i] && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                        vis[i] = true;
                    }
                }
            }
        }
        return delc;
    }
}
public class Day55-955 {
    
}
