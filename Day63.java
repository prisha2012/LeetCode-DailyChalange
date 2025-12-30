import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        if (bottom.length() == 1) return true;
        if (visited.contains(bottom)) return false;

        List<String> nextRows = new ArrayList<>();
        buildNext(bottom, 0, new StringBuilder(), nextRows);

        for (String next : nextRows) {
            if (dfs(next)) return true;
        }

        visited.add(bottom);
        return false;
    }

    private void buildNext(String bottom, int idx, StringBuilder path, List<String> res) {
        if (idx == bottom.length() - 1) {
            res.add(path.toString());
            return;
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            path.append(c);
            buildNext(bottom, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}