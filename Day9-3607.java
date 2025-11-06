import java.util.*;

class Solution {

    static class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return;
            if (rank[rx] < rank[ry]) {
                parent[rx] = ry;
            } else if (rank[ry] < rank[rx]) {
                parent[ry] = rx;
            } else {
                parent[ry] = rx;
                rank[rx]++;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        
        for (int[] conn : connections) {
            int u = conn[0] - 1;
            int v = conn[1] - 1;
            dsu.union(u, v);
        }

        Map<Integer, TreeSet<Integer>> compOnline = new HashMap<>();
        for (int i = 0; i < c; i++) {
            int root = dsu.find(i);
            compOnline.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        boolean[] online = new boolean[c];
        Arrays.fill(online, true);

        List<Integer> resultList = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1] - 1; 
            if (type == 2) {
                
                if (online[x]) {
                    online[x] = false;
                    int root = dsu.find(x);
                    TreeSet<Integer> set = compOnline.get(root);
                    if (set != null) set.remove(x);
                }
            } else if (type == 1) {
              
                if (online[x]) {
                    resultList.add(x + 1); 
                } else {
                    int root = dsu.find(x);
                    TreeSet<Integer> set = compOnline.get(root);
                    if (set == null || set.isEmpty())
                        resultList.add(-1);
                    else
                        resultList.add(set.first() + 1); 
                }
            }
        }

        
        int[] ans = new int[resultList.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = resultList.get(i);
        return ans;
    }
}
