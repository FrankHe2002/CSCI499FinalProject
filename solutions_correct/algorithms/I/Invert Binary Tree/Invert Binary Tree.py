# Runtime: 7 ms (Top 98.3%) | Memory: 13.26 MB (Top 67.3%)

class Solution(object):
    def invertTree(self, root):
        # Base case...
        if root == None:
            return root
        # swapping process...
        root.left, root.right = root.right, root.left
        # Call the function recursively for the left subtree...
        self.invertTree(root.left)
        # Call the function recursively for the right subtree...
        self.invertTree(root.right)
        return root     # Return the root...