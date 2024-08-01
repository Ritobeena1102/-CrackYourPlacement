class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    // Helper function to check the height of the subtree and if it's balanced
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // An empty tree is balanced and has height 0
        }
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }
        
        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        
        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
