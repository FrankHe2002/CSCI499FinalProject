// Runtime: 0 ms (Top 100.00%) | Memory: 39.1 MB (Top 33.67%)
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root){
        if(root == null)
            return;
        traversal(root.left);
        traversal(root.right);
        res.add(root.val);
    }
}