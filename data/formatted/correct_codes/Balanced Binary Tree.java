class Solution {

    public int treeHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        return (Math.max(left, right) + 1);

    }

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return (leftBalanced && rightBalanced && Math.abs(leftHeight - rightHeight) <= 1);

    }
}