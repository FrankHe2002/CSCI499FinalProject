```java
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i], new ArrayList<>());
            }
            List<Integer> ls = mp.get(arr[i]);
            ls.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int j = q.poll();
                if (j + 1 < n) {
                    if (j + 1 == n - 1) return ans;
                    q.offer(j + 1);
                }
                if (j - 1 >= 0) {
                    q.offer(j - 1);
                }
                if (mp.containsKey(arr[j])) {
                    for (int k : new ArrayList<>(mp.get(arr[j]))) {
                        if (k != j) {
                            if (k == n - 1) return ans;
                            q.offer(k);
                        }
                    }
                    mp.remove(arr[j]);
                }
            }
        }
        return ans;
    }
}
```