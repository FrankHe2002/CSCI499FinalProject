```java
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int zeroCount = 0, out = 0, len = arr.length;
        Arrays.sort(arr);
        for (int ar : arr) {
            if (ar % 2 == 1 || ar % 2 == -1)
                map.put(ar, map.getOrDefault(ar, 0) + 1);
            else {
                if (ar > 0 && map.getOrDefault(ar / 2, 0) > 0) {
                    out++;
                    map.put(ar / 2, map.get(ar / 2) - 1);
                } else if (ar < 0 && map.getOrDefault(ar * 2, 0) > 0) {
                    out++;
                    map.put(ar * 2, map.get(ar * 2) - 1);
                } else map.put(ar, map.getOrDefault(ar, 0) + 1);
            }
        }
        zeroCount = map.getOrDefault(0, 0) / 2;
        return out + zeroCount == len / 2;
    }
}
```