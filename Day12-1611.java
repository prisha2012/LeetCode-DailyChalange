class Solution {
    public int minimumOneBitOperations(int n) {
        if (n==0) return  0;
        int k=0;
        int temp=n;
        while((temp>>1)>0){
            temp>>=1;
            k++;
        }
        return (1<<(k+1))-1-minimumOneBitOperations(n^(1<<k));
    }
}