```java
class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Character, TreeSet<Integer>> locMap = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            locMap.computeIfAbsent(ring.charAt(i), o -> new TreeSet<>()).add(i);
        }
        return dfs(0, 0, locMap, key, new int[key.length()][ring.length()]);
    }

    private int dfs(int cur, int where, Map<Character, TreeSet<Integer>> locMap, String key, int[][] memo) {
        if (cur == key.length()) { // the end
            return 0;
        }
        if (memo[cur][where] > 0) { // have computed [cur, end) already.
            return memo[cur][where];
        }
        TreeSet<Integer> idx = locMap.get(key.charAt(cur));
        if (idx.contains(where)) { // greedily take this if it is already matched
            return memo[cur][where] = dfs(cur + 1, where, locMap, key, memo) + 1;
        }
        Integer hi = idx.higher(where); // otherwise, we can take the higher key
        Integer lo = idx.lower(where); // or, the lower key
        if (hi == null) { // if no higher key, it becomes the lowest key.
            hi = idx.first();
        }
        if (lo == null) { // if no lower key, it becomes the highest key.
            lo = idx.last();
        }
        int hcost = dfs(cur + 1, hi, locMap, key, memo) + (hi > where ? ring.length() - hi + where : hi - where);
        int lcost = dfs(cur + 1, lo, locMap, key, memo) + (lo <= where ? ring.length() - where + lo : where - lo);
        return memo[cur][where] = Math.min(hcost, lcost) + 1;
    }
}
```