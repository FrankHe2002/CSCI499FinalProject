```java
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n + 1];
        return Sol(graph, 1, t, target, vis, 1.0); // Added 6th parameter to store the probability
    }

    public double Sol(List<List<Integer>> graph, int ver, int t, int tar, boolean[] vis, double probability) {
        if (t < 0) return 0;
        vis[ver] = true;

        int count = 0;
        for (Integer child : graph.get(ver)) {
            if (!vis[child]) count++;
        }

        if (ver == tar) {
            if (count == 0 || t == 0) 
                return probability; // Return the probability
            else 
                return 0;
        }

        if (graph.get(ver).size() == 0) return 0;

        double ans = 0.0;

        for (Integer child : graph.get(ver)) {
            if (!vis[child])
                ans += (double) (1.0 / count) * Sol(graph, child, t - 1, tar, vis, probability / count);
        }
        vis[ver] = false;
        return ans;
    }
}
```