class Solution {
    int[] parent;
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb)parent[pb]=pa;
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent=new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
        union(0,firstPerson);

        Arrays.sort(meetings,(a,b)->a[2]-b[2]);
        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            List<int[]> batch=new ArrayList<>();
            while(i<meetings.length&&meetings[i][2]==time){
                batch.add(meetings[i]);
                i++;
            }
            for(int[] m:batch) union(m[0],m[1]);
            for(int[] m:batch){
                if(find(m[0])!=find(0)){
                    parent[m[0]]=m[0];
                    parent[m[1]]=m[1];
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(find(j)==find(0)){
                res.add(j);
            }
        }
        return res;
    }
}