```java
import java.util.*;

class Solution {
    private List<Integer>[] groups;
    private List<Integer>[] graph;
    private int[] indegrees;
    private int[] indegreeGroups;

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        buildGroups(n, group);
        buildGraph(n, beforeItems, group);
        int[] result = new int[n];
        int top = - 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegreeGroups[group[i]] == 0) {
                queue.offer(group[i]);
            }
        }
        while (!queue.isEmpty()) {
            Integer groupId = queue.poll();
            List<Integer> groupItems = groups[groupId];
            if (groupItems == null) continue;
            Queue<Integer> itemQueue = new LinkedList<>();
            for (var item : groupItems) {
                if (indegrees[item] == 0) {
                    itemQueue.offer(item);
                }
            }
            while (!itemQueue.isEmpty()) {
                Integer item = itemQueue.poll();
                result[++top] = item;
                if (graph[item] == null) continue;
                for (var neighbor : graph[item]) {
                    indegrees[neighbor]--;
                    if (--indegreeGroups[group[neighbor]] == 0) {
                        queue.offer(group[neighbor]);
                    } else if (indegrees[neighbor] == 0) {
                        itemQueue.offer(neighbor);
                    }
                }
            }
        }
        if (top < n - 1) return new int[]{};
        return result;
    }

    private void buildGroups(int n, int[] group) {
        groups = new List[n];
        int index = n - 1;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = index--;
            }
            if (groups[group[i]] == null) {
                groups[group[i]] = new ArrayList<>();
            }
            groups[group[i]].add(i);
        }
    }

    private void buildGraph(int n, List<List<Integer>> beforeItems, int[] group) {
        graph = new List[n];
        indegrees = new int[n];
        indegreeGroups = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (graph[j] == null) {
                    graph[j] = new ArrayList<>();
                }
                graph[j].add(i);
                indegrees[i]++;
                if (group[i] != group[j]) {
                    indegreeGroups[group[i]]++;
                }
            }
        }
    }
}
```