class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        Map<Integer,Integer> freq=new HashMap<>();

        for(int i=0;i<k;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        result[0]=completeSum(freq,x);
        for(int i=k;i<n;i++){
            int out=nums[i-k];
            int in=nums[i];
            freq.put(out,freq.get(out)-1);
            if(freq.get(out)==0)freq.remove(out);
            freq.put(in, freq.getOrDefault(in, 0) + 1);
                result[i - k + 1] = completeSum(freq, x);

        }
        return result;
        
    }
    private int completeSum(Map<Integer,Integer> freq,int x){
        List<int[]> l=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:freq.entrySet()){
            l.add(new int[]{e.getKey(),e.getValue()});
        }

        l.sort((a,b)->{
            if(b[1]!=a[1]) return b[1]-a[1];
            return b[0]-a[0];
        });

        int sum=0;
        for(int i=0;i<Math.min(x,l.size());i++){
              sum += l.get(i)[0] * l.get(i)[1];
        }
        return sum;

    }

public class Day8-3318 {
    
}
