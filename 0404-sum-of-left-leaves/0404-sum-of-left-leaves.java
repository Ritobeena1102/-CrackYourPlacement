class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }
    
    // Helper function to compute the sum of left leaves
    private int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
        // Base case: if node is null, return 0
        if (node == null) {
            return 0;
        }
        
        // Check if the current node is a leaf
        if (node.left == null && node.right == null) {
            // If it's a left leaf, add its value
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }
        
        // Recursively compute the sum of left leaves in both subtrees
        int leftSum = sumOfLeftLeavesHelper(node.left, true);
        int rightSum = sumOfLeftLeavesHelper(node.right, false);
        
        // Return the total sum
        return leftSum + rightSum;
    }
}
