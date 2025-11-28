public class Day32-2872 {
    
}
class Solution {
    int ans = 0;
    int k;
    List<Integer>[] graph;
    int[] values;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(0, -1);
        return ans;
    }

    private long dfs(int node, int parent) {
        long sum = values[node];

        for (int nei : graph[node]) {
            if (nei == parent) continue;
            sum += dfs(nei, node);
        }

        if (sum % k == 0) {
            ans++;
            return 0;   // cut component
        }

        return sum % k;
    }
}
