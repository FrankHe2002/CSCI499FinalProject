```java
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < forbidden.length; i++) {
            visited.add(forbidden[i]);
        }
        Map<Integer, Integer> jumps = new HashMap<>();
        jumps.put(0, 0);
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {0, 1});
        while (q.size() != 0) {
            Integer[] ud = q.poll();
            int u = ud[0], d = ud[1];
            if (u == x) {
                return jumps.get(u);
            }
            if (u + a < 6001 && !visited.contains(u + a)) {
                q.add(new Integer[] {u + a, 1});
                visited.add(u + a);
                jumps.put(u + a, jumps.get(u) + 1);
            }
            if (d != -1 && u - b > -1 && !visited.contains(u - b)) {
                q.add(new Integer[] {u - b, -1});
                visited.add(u - b);
                jumps.put(u - b, jumps.get(u) + 1);
            }
        }
        return -1;
    }
}
```