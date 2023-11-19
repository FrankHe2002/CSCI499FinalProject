```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = helper(lo, i - 1);
            List<TreeNode> right = helper(i + 1, hi);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode head = new TreeNode(i);
                    head.left = l;
                    head.right = r;

                    res.add(head);
                }
            }
        }

        return res;
    }
}
```