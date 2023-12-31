```java
class Solution {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            res += Math.max(0, target[i] - target[i - 1]);
        }
        return res;
    }
}
```