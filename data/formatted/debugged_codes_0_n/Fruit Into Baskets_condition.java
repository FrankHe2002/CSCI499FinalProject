```java
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int start = 0, end = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (end < fruits.length) {
            if (map.size() < 2) {
                map.put(fruits[end], end);
                end++;
            } else if (!map.containsKey(fruits[end])) {
                int leftMost = fruits.length;
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(fruits[leftMost]);
                start = leftMost + 1;
            } else {
                end++;
            }

            res = Math.max(res, end - start);
        }
        return res;
    }
}
```