public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder string = new StringBuilder();
        traverse(root, string);
        return string.toString();
    }

    private void traverse(TreeNode root, StringBuilder string) {
        if (root == null) return;
        string.append(root.val).append(",");
        traverse(root.left, string);
        traverse(root.right, string);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] dataArr = data.split(",");
        int[] index = {0};

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[index[0]]));
        index[0]++;

        for (int i = index[0]; i < dataArr.length; i++)
            insert(Integer.parseInt(dataArr[i]), root);

        return root;
    }

    private void insert(int digit, TreeNode root) {

        if (digit > root.val) {
            if (root.right != null)
                insert(digit, root.right);
            else
                root.right = new TreeNode(digit);
        } else {
            if (root.left != null)
                insert(digit, root.left);
            else
                root.left = new TreeNode(digit);
        }

    }
}