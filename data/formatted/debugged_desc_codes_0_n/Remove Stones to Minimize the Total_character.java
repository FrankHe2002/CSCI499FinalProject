```java
// Runtime: 304 ms (Top 95.0%) | Memory: 58.55 MB (Top 23.6%)

class Solution {
    public int minStoneSum(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int a : A) {
            pq.add(a);
            res += a;
        }
        while (k-- > 0) {
            int a = pq.poll();
            pq.add(a - (int)Math.floor(a / 2.0));
            res -= (int)Math.floor(a / 2.0);
        }
        return res;
    }
}
```