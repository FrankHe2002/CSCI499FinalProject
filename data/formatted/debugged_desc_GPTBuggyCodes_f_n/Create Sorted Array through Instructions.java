```java
class Fenwick {
    public int[] tree;

    public Fenwick(int length) {
        tree = new int[length + 1];
    }

    public int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i = i - (i & -i);
        }
        return sum;
    }

    public void update(int i, int k) {
        while (i < tree.length) {
            tree[i] += k;
            i = i + (i & -i);
        }
    }
}

class Solution {
    public int createSortedArray(int[] instructions) {
        if (instructions.length == 0) {
            return 0;
        }
        int max = 0;
        for (int value : instructions) {
            if (value > max) {
                max = value;
            }
        }
        Fenwick tree = new Fenwick(max + 1);
        int cost = 0;

        for (int i = 0; i < instructions.length; i++) {
            int current_value = instructions[i];
            int strictly_less = tree.sum(current_value - 1);
            int strictly_greater = i - tree.sum(current_value);
            cost += Math.min(strictly_less, strictly_greater);
            cost = cost % ((int) 1e9 + 7);
            tree.update(current_value, 1);
        }

        return cost;
    }
}
```