```java
class Solution {
    int xkaLeft, xkaRight;

    public int size(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left, x);
        int rs = size(node.right, x);

        if (node.val == x) {
            xkaLeft = ls;
            xkaRight = rs;
        }

        return ls + rs + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        xkaLeft = 0;
        xkaRight = 0;
        size(root, x);
        int parent = n - (xkaLeft + xkaRight + 1);
        int max = Math.max(parent, Math.max(xkaRight, xkaLeft));
        if (max > n / 2) {
            return true;
        }
        return false;
    }
}
```