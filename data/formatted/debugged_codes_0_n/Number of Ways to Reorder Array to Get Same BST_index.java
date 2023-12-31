```java
import java.util.*;

class Solution {
    long[][] pascal;
    private static final long mod = 1000000007;
    long one = 1;

    public int numOfWays(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        formPascal(nums);
        return (int) dfs(list) - 1;
    }

    public long dfs(ArrayList<Integer> list) {
        if (list.size() <= 2) return 1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int root = list.get(0);
        for (int n : list) {
            if (n > root)
                right.add(n);
            else if (n < root)
                left.add(n);
        }

        return ((pascal[left.size() + right.size()][left.size()]) * (dfs(left) % mod)) % mod * (dfs(right) % mod);


    }

    private void formPascal(int[] nums) {
        pascal = new long[nums.length + 1][];
        for (int i = 0; i <= nums.length; i++) {
            pascal[i] = new long[i + 1];
            Arrays.fill(pascal[i], one);
        }
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 1; j < i; j++) {
                pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % mod;
            }
        }
    }
}
```