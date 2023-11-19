class Solution {
    public int maxAncestorDiff(TreeNode root) {

        if (root == null) return 0;

        return find(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public int find(TreeNode root, int min, int max) {
        if (root == null) return Math.abs(max - min);

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        return Math.max(find(root.left, min, max), find(root.right, min, max));
    }

}